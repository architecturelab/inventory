FROM gradle:7.4.2-jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src/

WORKDIR /home/gradle/src/
RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/application/build/libs/inventory-application-0.0.1-SNAPSHOT.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]
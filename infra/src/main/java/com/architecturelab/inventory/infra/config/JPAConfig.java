package com.architecturelab.inventory.infra.config;

import com.architecturelab.inventory.infra.jpa.dao.ItemInputJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.architecturelab.inventory"})
@EntityScan("com.architecturelab.inventory")
public class JPAConfig {

    @Autowired
    private ItemInputJpaDao itemInputJpaDao;
}

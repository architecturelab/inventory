package com.architecturelab.inventory.infra.jpa.repository.dependency;

import com.architecturelab.inventory.infra.jpa.dao.DependencyDao;
import com.architecturelab.inventory.infra.jpa.domain.Dependency;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class DependencyJpaRepositoryImpl implements DependencyJpaRepository {

    @Autowired
    private DependencyDao dependencyDao;

    @Override
    public Dependency save(Dependency entity) {
        return dependencyDao.save(entity);
    }

    @Override
    public Iterable<Dependency> getAll() {
        return dependencyDao.findAll();
    }

    @Override
    public Optional<Dependency> getById(Long id) {
        return dependencyDao.findById(id);
    }
}

package com.architecturelab.inventory.infra.jpa.repository.model;

import com.architecturelab.inventory.infra.jpa.dao.ModelDao;
import com.architecturelab.inventory.infra.jpa.domain.Model;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ModelJpaRepositoryImpl implements ModelJpaRepository {

    @Autowired
    private ModelDao modelDao;

    @Override
    public Model save(Model entity) {
        return modelDao.save(entity);
    }

    @Override
    public Iterable<Model> getAll() {
        return modelDao.findAll();
    }

    @Override
    public Optional<Model> getById(Long id) {
        return modelDao.findById(id);
    }
}

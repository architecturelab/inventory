package com.architecturelab.inventory.infra.jpa.repository.brand;

import com.architecturelab.inventory.infra.jpa.dao.BrandDao;
import com.architecturelab.inventory.infra.jpa.domain.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class BrandJpaRepositoryImpl implements BrandJpaRepository {

    @Autowired
    private BrandDao brandDao;

    @Override
    public Brand save(Brand entity) {
        return brandDao.save(entity);
    }

    @Override
    public Iterable<Brand> getAll() {
        return brandDao.findAll();
    }

    @Override
    public Optional<Brand> getById(Long id) {
        return brandDao.findById(id);
    }
}

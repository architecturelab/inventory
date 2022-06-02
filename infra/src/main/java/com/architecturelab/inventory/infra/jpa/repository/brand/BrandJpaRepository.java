package com.architecturelab.inventory.infra.jpa.repository.brand;

import com.architecturelab.inventory.infra.jpa.domain.BaseEntity;
import com.architecturelab.inventory.infra.jpa.domain.Brand;

import java.util.Optional;

public interface BrandJpaRepository {

    public Brand save(Brand entity);

    public Iterable<Brand> getAll();

    public Optional<Brand> getById(Long id);

}

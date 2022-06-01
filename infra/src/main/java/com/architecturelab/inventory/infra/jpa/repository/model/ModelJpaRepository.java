package com.architecturelab.inventory.infra.jpa.repository.model;

import com.architecturelab.inventory.infra.jpa.domain.Brand;
import com.architecturelab.inventory.infra.jpa.domain.Model;

import java.util.Optional;

public interface ModelJpaRepository {

    public Model save(Model entity);

    public Iterable<Model> getAll();

    public Optional<Model> getById(Long id);

}

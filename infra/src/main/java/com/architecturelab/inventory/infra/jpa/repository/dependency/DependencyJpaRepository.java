package com.architecturelab.inventory.infra.jpa.repository.dependency;

import com.architecturelab.inventory.infra.jpa.domain.Dependency;

import java.util.Optional;

public interface DependencyJpaRepository {

    public Dependency save(Dependency entity);

    public Iterable<Dependency> getAll();

    public Optional<Dependency> getById(Long id);

}

package com.architecturelab.inventory.infra.jpa.repository.type;

import com.architecturelab.inventory.infra.jpa.domain.Type;

import java.util.Optional;

public interface TypeJpaRepository {

    public Type save(Type entity);

    public Iterable<Type> getAll();

    public Optional<Type> getById(Long id);

}

package com.architecturelab.inventory.infra.jpa.repository.item;

import com.architecturelab.inventory.infra.jpa.domain.BaseEntity;
import com.architecturelab.inventory.infra.jpa.domain.Item;

import java.util.Optional;

public interface ItemJpaRepository {

    public Item save(Item entity);

    public Iterable<Item> getAll();

    public Optional<Item> getById(Long id);

}

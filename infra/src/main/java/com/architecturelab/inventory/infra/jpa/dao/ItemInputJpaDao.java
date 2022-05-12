package com.architecturelab.inventory.infra.jpa.dao;

import com.architecturelab.inventory.infra.jpa.domain.ItemInputJpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemInputJpaDao extends CrudRepository<ItemInputJpa, UUID> {
}

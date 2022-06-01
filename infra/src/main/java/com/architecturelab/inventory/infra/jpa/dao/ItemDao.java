package com.architecturelab.inventory.infra.jpa.dao;

import com.architecturelab.inventory.infra.jpa.domain.BaseEntity;
import com.architecturelab.inventory.infra.jpa.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends CrudRepository<Item, Long> {
}

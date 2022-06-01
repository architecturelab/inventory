package com.architecturelab.inventory.infra.jpa.dao;

import com.architecturelab.inventory.infra.jpa.domain.Brand;
import com.architecturelab.inventory.infra.jpa.domain.Model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModelDao extends CrudRepository<Model, Long> {
}

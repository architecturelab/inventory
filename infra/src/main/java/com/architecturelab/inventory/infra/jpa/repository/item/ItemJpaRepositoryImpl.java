package com.architecturelab.inventory.infra.jpa.repository.item;

import com.architecturelab.inventory.infra.jpa.dao.ItemDao;
import com.architecturelab.inventory.infra.jpa.domain.BaseEntity;
import com.architecturelab.inventory.infra.jpa.domain.Item;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@EnableJpaRepositories(basePackages = {"com.architecturelab.inventory"})
@EntityScan("com.architecturelab.inventory")
public class ItemJpaRepositoryImpl implements ItemJpaRepository {

    @Autowired
    private ItemDao itemDao;

    @Override
    public Item save(Item entity) {
        return itemDao.save(entity);
    }

    @Override
    public Iterable<Item> getAll() {
        return itemDao.findAll();
    }

    @Override
    public Optional<Item> getById(Long id) {
        return itemDao.findById(id);
    }
}

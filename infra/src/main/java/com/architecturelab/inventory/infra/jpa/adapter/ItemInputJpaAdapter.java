package com.architecturelab.inventory.infra.jpa.adapter;

import com.architecturelab.inventory.infra.jpa.ItemInputJpaRepository;
import com.architecturelab.inventory.infra.jpa.dao.ItemInputJpaDao;
import com.architecturelab.inventory.infra.jpa.domain.ItemInputJpa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemInputJpaAdapter implements ItemInputJpaRepository {

    private ItemInputJpaDao itemInputJpaDao;

    @Override
    public void createItemInput() {
        itemInputJpaDao.save(new ItemInputJpa());
    }
}

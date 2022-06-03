package com.architecturelab.inventory.useCases.item;

import com.architecturelab.inventory.core.domain.item.ItemOutput;

import java.util.List;

public interface ItemOutputUseCases {
    public List<ItemOutput> getAll();

    public ItemOutput getById(Long id);
}

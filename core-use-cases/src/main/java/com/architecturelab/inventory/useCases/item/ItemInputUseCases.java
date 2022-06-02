package com.architecturelab.inventory.useCases.item;


import com.architecturelab.inventory.core.domain.item.ItemInput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemInputUseCases {

    public ItemInput create(ItemInput itemInput);

    public ItemInput update(ItemInput itemInput);

    public List<ItemInput> getAll();

    public ItemInput getById(Long id);

}

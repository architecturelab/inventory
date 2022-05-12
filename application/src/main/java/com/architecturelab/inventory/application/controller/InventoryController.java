package com.architecturelab.inventory.application.controller;

import com.architecturelab.inventory.useCases.item.CreateItemInputUseCase;
import com.architecturelab.inventory.useCases.item.GetItemOutputUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private CreateItemInputUseCase createItemInputUseCase;

    @Autowired
    private GetItemOutputUseCase getItemOutputUseCase;

    @GetMapping("/items")
    public String getAllItems() {
        getItemOutputUseCase.execute();
        return "Get items";
    }

    @GetMapping("/item/{id}")
    public String getItemById(@PathVariable Long id) {
        return "get item by id " + id;
    }

    @PostMapping("/item")
    public String createItem() {
        createItemInputUseCase.execute();
        return "Creating item";
    }

    @PutMapping("/item/{id}")
    public String updateItem(@PathVariable Long id) {
        return "updating item by id " + id;
    }
}

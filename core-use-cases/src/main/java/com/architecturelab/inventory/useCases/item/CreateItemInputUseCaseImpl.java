package com.architecturelab.inventory.useCases.item;

import com.architecturelab.inventory.infra.jpa.ItemInputJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateItemInputUseCaseImpl implements CreateItemInputUseCase{

    @Autowired
    private ItemInputJpaRepository itemInputJpaRepository;

    @Override
    public void execute() {
        itemInputJpaRepository.createItemInput();
    }
}

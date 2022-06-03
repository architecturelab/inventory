package com.architecturelab.inventory.useCases.item;

import com.architecturelab.inventory.core.domain.item.ItemInput;
import com.architecturelab.inventory.core.domain.item.ItemOutput;
import com.architecturelab.inventory.infra.jpa.domain.Item;
import com.architecturelab.inventory.infra.jpa.repository.item.ItemJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemOutputUseCasesImpl implements ItemOutputUseCases {


    @Autowired
    private ItemJpaRepository itemJpaRepository;


    @Override
    public List<ItemOutput> getAll() {

        List<Item> items = (List<Item>) itemJpaRepository.getAll();

        List<ItemOutput> outputs = new ArrayList<ItemOutput>();

        items.forEach(i -> {
            ItemOutput item = new ItemOutput(
                    i.getId(),
                    i.getType().getId(),
                    i.getType().getNombre(),
                    i.getBrand().getId(),
                    i.getBrand().getNombre(),
                    i.getModel().getId(),
                    i.getModel().getNombre(),
                    i.getSerial(),
                    i.getFechaIngreso(),
                    i.getFechaFinalGarantia(),
                    i.getValor(),
                    i.getFechaBaja(),
                    i.getEstado(),
                    i.getObservacion(),
                    i.getDependency().getId(),
                    i.getDependency().getNombre(),
                    i.getUsuarioCreacion(),
                    i.getFechaCreacion(),
                    i.getUsuarioModifica()
            );
            outputs.add(item);
        });
        return outputs;
    }

    @Override
    public ItemOutput getById(Long id) {
        Optional<Item> itemData = itemJpaRepository.getById(id);
        if (itemData.isPresent()){
            Item item = itemData.get();
            ItemOutput output = new ItemOutput(
                    item.getId(),
                    item.getType().getId(),
                    item.getType().getNombre(),
                    item.getBrand().getId(),
                    item.getBrand().getNombre(),
                    item.getModel().getId(),
                    item.getModel().getNombre(),
                    item.getSerial(),
                    item.getFechaIngreso(),
                    item.getFechaFinalGarantia(),
                    item.getValor(),
                    item.getFechaBaja(),
                    item.getEstado(),
                    item.getObservacion(),
                    item.getDependency().getId(),
                    item.getDependency().getNombre(),
                    item.getUsuarioCreacion(),
                    item.getFechaCreacion(),
                    item.getUsuarioModifica()
            );
            return output;
        }
        return null;
    }
}

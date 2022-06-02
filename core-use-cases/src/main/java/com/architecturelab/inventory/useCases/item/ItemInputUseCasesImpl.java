package com.architecturelab.inventory.useCases.item;

import com.architecturelab.inventory.core.domain.item.ItemInput;
import com.architecturelab.inventory.infra.jpa.domain.*;
import com.architecturelab.inventory.infra.jpa.repository.item.ItemJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ItemInputUseCasesImpl implements ItemInputUseCases {

    @Autowired
    private ItemJpaRepository itemJpaRepository;

    @Override
    public ItemInput create(ItemInput itemInput) {
        Item item = itemJpaRepository.save(new Item(
                itemInput.getItemId(),
                new Type(itemInput.getClaseId()),
                new Brand(itemInput.getMarcaId()),
                new Model(itemInput.getModeloId()),
                itemInput.getSerial(),
                itemInput.getFechaIngreso(),
                itemInput.getFechaFinalGarantia(),
                itemInput.getValor(),
                itemInput.getFechaBaja(),
                itemInput.getEstado(),
                itemInput.getObservacion(),
                new Dependency(itemInput.getDependenciaId()),
                itemInput.getUsuarioCreacion(),
                itemInput.getFechaCreacion(),
                itemInput.getUsuarioModifica()
        ));
        ItemInput input = new ItemInput(
                item.getId(),
                item.getType().getId(),
                item.getBrand().getId(),
                item.getModel().getId(),
                item.getSerial(),
                item.getFechaIngreso(),
                item.getFechaFinalGarantia(),
                item.getValor(),
                item.getFechaBaja(),
                item.getEstado(),
                item.getObservacion(),
                item.getDependency().getId(),
                item.getUsuarioCreacion(),
                item.getFechaCreacion(),
                item.getUsuarioModifica()
        );
        return input;
    }

    @Override
    public ItemInput update(ItemInput itemInput) {
        Optional<Item> itemData = itemJpaRepository.getById(itemInput.getItemId());
        if (itemData.isPresent()){
            Item item = itemData.get();
            item.setType(new Type(itemInput.getClaseId()));
            item.setBrand(new Brand(itemInput.getMarcaId()));
            item.setModel(new Model(itemInput.getModeloId()));
            item.setSerial(itemInput.getSerial());
            item.setFechaIngreso(itemInput.getFechaIngreso());
            item.setFechaFinalGarantia(itemInput.getFechaFinalGarantia());
            item.setValor(itemInput.getValor());
            item.setFechaBaja(itemInput.getFechaBaja());
            item.setEstado(itemInput.getEstado());
            item.setObservacion(itemInput.getObservacion());
            item.setDependency(new Dependency(itemInput.getDependenciaId()));
            item.setUsuarioCreacion(itemInput.getUsuarioCreacion());
            item.setFechaCreacion(itemInput.getFechaCreacion());
            item.setUsuarioModifica(itemInput.getUsuarioModifica());

            Item updated = itemJpaRepository.save(item);
            ItemInput input = new ItemInput(
                    updated.getId(),
                    updated.getType().getId(),
                    updated.getBrand().getId(),
                    updated.getModel().getId(),
                    updated.getSerial(),
                    updated.getFechaIngreso(),
                    updated.getFechaFinalGarantia(),
                    updated.getValor(),
                    updated.getFechaBaja(),
                    updated.getEstado(),
                    updated.getObservacion(),
                    updated.getDependency().getId(),
                    updated.getUsuarioCreacion(),
                    updated.getFechaCreacion(),
                    updated.getUsuarioModifica()
            );
            return input;
        }
        return null;
    }

    @Override
    public List<ItemInput> getAll() {
        List<Item> items = (List<Item>) itemJpaRepository.getAll();

        List<ItemInput> inputs = new ArrayList<ItemInput>();

        items.forEach(i -> {
            ItemInput item = new ItemInput(
                    i.getId(),
                    i.getType().getId(),
                    i.getBrand().getId(),
                    i.getModel().getId(),
                    i.getSerial(),
                    i.getFechaIngreso(),
                    i.getFechaFinalGarantia(),
                    i.getValor(),
                    i.getFechaBaja(),
                    i.getEstado(),
                    i.getObservacion(),
                    i.getDependency().getId(),
                    i.getUsuarioCreacion(),
                    i.getFechaCreacion(),
                    i.getUsuarioModifica()
            );
            inputs.add(item);
        });
        return inputs;
    }

    @Override
    public ItemInput getById(Long id) {
        Optional<Item> itemData = itemJpaRepository.getById(id);
        if (itemData.isPresent()){
            Item item = itemData.get();
            ItemInput input = new ItemInput(
                    item.getId(),
                    item.getType().getId(),
                    item.getBrand().getId(),
                    item.getModel().getId(),
                    item.getSerial(),
                    item.getFechaIngreso(),
                    item.getFechaFinalGarantia(),
                    item.getValor(),
                    item.getFechaBaja(),
                    item.getEstado(),
                    item.getObservacion(),
                    item.getDependency().getId(),
                    item.getUsuarioCreacion(),
                    item.getFechaCreacion(),
                    item.getUsuarioModifica()
            );
            return input;
        }
        return null;
    }
}

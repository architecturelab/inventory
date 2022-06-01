package com.architecturelab.inventory.useCases.brand;


import com.architecturelab.inventory.core.domain.brand.BrandInput;
import com.architecturelab.inventory.infra.jpa.domain.*;
import com.architecturelab.inventory.infra.jpa.repository.brand.BrandJpaRepository;
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
public class BrandUseCasesImpl implements BrandUseCases {

    @Autowired
    private BrandJpaRepository brandRepository;

    @Override
    public BrandInput create(BrandInput brandInput) {
        Brand brand = brandRepository.save(new Brand(
                brandInput.getMarcaId(),
                brandInput.getNombre(),
                brandInput.getVidaUtil(),
                brandInput.getVigente()
        ));
        BrandInput input = new BrandInput(
                brand.getId(),
                brand.getNombre(),
                brand.getVidaUtil(),
                brand.getVigente()
        );
        return input;
    }

    @Override
    public BrandInput update(BrandInput brandInput) {
        Optional<Brand> brandData = brandRepository.getById(brandInput.getMarcaId());
        if (brandData.isPresent()){
            Brand brand = brandData.get();
            brand.setNombre(brandInput.getNombre());
            brand.setVidaUtil(brandInput.getVidaUtil());
            brand.setVigente(brandInput.getVigente());

            Brand updated = brandRepository.save(brand);
            BrandInput input = new BrandInput(
                    updated.getId(),
                    updated.getNombre(),
                    updated.getVidaUtil(),
                    updated.getVigente()
            );
            return input;
        }
        return null;
    }

    @Override
    public List<BrandInput> getAll() {

        List<Brand> brands = (List<Brand>) brandRepository.getAll();

        List<BrandInput> inputs = new ArrayList<BrandInput>();
        brands.forEach(b-> {
            BrandInput brand = new BrandInput(
                    b.getId(),
                    b.getNombre(),
                    b.getVidaUtil(),
                    b.getVigente()
            );
            inputs.add(brand);
        });
        return inputs;
    }

    @Override
    public BrandInput getById(Long id) {
        Optional<Brand> brandData = brandRepository.getById(id);
        if (brandData.isPresent()) {
            Brand brand = brandData.get();
            BrandInput input = new BrandInput(
                    brand.getId(),
                    brand.getNombre(),
                    brand.getVidaUtil(),
                    brand.getVigente()
            );
            return input;
        }
        return null;
    }
}

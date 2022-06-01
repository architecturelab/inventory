package com.architecturelab.inventory.useCases.type;


import com.architecturelab.inventory.core.domain.brand.BrandInput;
import com.architecturelab.inventory.core.domain.type.TypeInput;
import com.architecturelab.inventory.infra.jpa.domain.Brand;
import com.architecturelab.inventory.infra.jpa.domain.Type;
import com.architecturelab.inventory.infra.jpa.repository.brand.BrandJpaRepository;
import com.architecturelab.inventory.infra.jpa.repository.type.TypeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeUseCasesImpl implements TypeUseCases {

    @Autowired
    private TypeJpaRepository typeRepository;

    @Override
    public TypeInput create(TypeInput typeInput) {
        Type type = typeRepository.save(new Type(
                typeInput.getClaseId(),
                typeInput.getNombre(),
                typeInput.getVidaUtil(),
                typeInput.getVigente()
        ));
        TypeInput input = new TypeInput(
                type.getId(),
                type.getNombre(),
                type.getVidaUtil(),
                type.getVigente()
        );
        return input;
    }

    @Override
    public TypeInput update(TypeInput typeInput) {
            Optional<Type> typeData = typeRepository.getById(typeInput.getClaseId());
        if (typeData.isPresent()){
            Type type = typeData.get();
            type.setNombre(typeInput.getNombre());
            type.setVidaUtil(typeInput.getVidaUtil());
            type.setVigente(typeInput.getVigente());

            Type updated = typeRepository.save(type);
            TypeInput input = new TypeInput(
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
    public List<TypeInput> getAll() {

        List<Type> brands = (List<Type>) typeRepository.getAll();

        List<TypeInput> inputs = new ArrayList<TypeInput>();

        brands.forEach(t-> {
            TypeInput type = new TypeInput(
                    t.getId(),
                    t.getNombre(),
                    t.getVidaUtil(),
                    t.getVigente()
            );
            inputs.add(type);
        });
        return inputs;
    }

    @Override
    public TypeInput getById(Long id) {
        Optional<Type> typeData = typeRepository.getById(id);
        if (typeData.isPresent()) {
            Type type = typeData.get();
            TypeInput input = new TypeInput(
                    type.getId(),
                    type.getNombre(),
                    type.getVidaUtil(),
                    type.getVigente()
            );
            return input;
        }
        return null;
    }
}

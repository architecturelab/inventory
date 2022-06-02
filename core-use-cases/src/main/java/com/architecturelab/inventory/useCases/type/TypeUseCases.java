package com.architecturelab.inventory.useCases.type;

import com.architecturelab.inventory.core.domain.type.TypeInput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeUseCases {

    public TypeInput create(TypeInput typeInput);

    public TypeInput update(TypeInput typeInput);

    public List<TypeInput> getAll();

    public TypeInput getById(Long id);
}

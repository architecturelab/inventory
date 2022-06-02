package com.architecturelab.inventory.useCases.dependency;


import com.architecturelab.inventory.core.domain.brand.BrandInput;
import com.architecturelab.inventory.core.domain.dependency.DependencyInput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DependencyUseCases {

    public DependencyInput create(DependencyInput dependencyInput);

    public DependencyInput update(DependencyInput dependencyInput);

    public List<DependencyInput> getAll();

    public DependencyInput getById(Long id);
}

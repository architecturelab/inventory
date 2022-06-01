package com.architecturelab.inventory.useCases.dependency;

import com.architecturelab.inventory.core.domain.dependency.DependencyInput;
import com.architecturelab.inventory.infra.jpa.domain.Brand;
import com.architecturelab.inventory.infra.jpa.domain.Dependency;
import com.architecturelab.inventory.infra.jpa.repository.brand.BrandJpaRepository;
import com.architecturelab.inventory.infra.jpa.repository.dependency.DependencyJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DependencyUseCasesImpl implements DependencyUseCases {

    @Autowired
    private DependencyJpaRepository dependencyRepository;

    @Override
    public DependencyInput create(DependencyInput dependencyInput) {
        Dependency dependency = dependencyRepository.save(new Dependency(
                dependencyInput.getDependenciaId(),
                dependencyInput.getNombre(),
                dependencyInput.getVigente()
        ));
        DependencyInput input = new DependencyInput(
                dependency.getId(),
                dependency.getNombre(),
                dependency.getVigente()
        );
        return input;
    }

    @Override
    public DependencyInput update(DependencyInput DependencyInput) {
        Optional<Dependency> dependencyData = dependencyRepository.getById(DependencyInput.getDependenciaId());
        if (dependencyData.isPresent()){
            Dependency dependency = dependencyData.get();
            dependency.setNombre(DependencyInput.getNombre());
            dependency.setVigente(DependencyInput.getVigente());

            Dependency updated = dependencyRepository.save(dependency);
            DependencyInput input = new DependencyInput(
                    updated.getId(),
                    updated.getNombre(),
                    updated.getVigente()
            );
            return input;
        }
        return null;
    }

    @Override
    public List<DependencyInput> getAll() {

        List<Dependency> brands = (List<Dependency>) dependencyRepository.getAll();

        List<DependencyInput> inputs = new ArrayList<DependencyInput>();
        brands.forEach(d-> {
            DependencyInput dependency = new DependencyInput(
                    d.getId(),
                    d.getNombre(),
                    d.getVigente()
            );
            inputs.add(dependency);
        });
        return inputs;
    }

    @Override
    public DependencyInput getById(Long id) {
        Optional<Dependency> dependencyData = dependencyRepository.getById(id);
        if (dependencyData.isPresent()) {
            Dependency dependency = dependencyData.get();
            DependencyInput input = new DependencyInput(
                    dependency.getId(),
                    dependency.getNombre(),
                    dependency.getVigente()
            );
            return input;
        }
        return null;
    }
}

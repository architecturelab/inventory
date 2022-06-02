package com.architecturelab.inventory.useCases.model;

import com.architecturelab.inventory.core.domain.model.ModelInput;
import com.architecturelab.inventory.core.domain.model.ModelOutput;
import com.architecturelab.inventory.infra.jpa.domain.Brand;
import com.architecturelab.inventory.infra.jpa.domain.Model;
import com.architecturelab.inventory.infra.jpa.repository.model.ModelJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelUseCasesImpl implements ModelUseCases{

    @Autowired
    private ModelJpaRepository modelRepository;

    @Override
    public ModelInput create(ModelInput modelInput) {
        Model model = modelRepository.save(new Model(
                new Brand(modelInput.getMarcaId()),
                modelInput.getNombre(),
                modelInput.getVidaUtil(),
                modelInput.getVigente()
        ));
        ModelInput input = new ModelInput(
                model.getId(),
                model.getBrand().getId(),
                model.getNombre(),
                model.getVidaUtil(),
                model.getVigente()
        );
        return input;
    }

    @Override
    public ModelInput update(ModelInput modelInput) {
        Optional<Model> ModelData = modelRepository.getById(modelInput.getModeloId());
        if (ModelData.isPresent()){
            Model model = ModelData.get();
            model.setBrand(new Brand(modelInput.getMarcaId()));
            model.setNombre(modelInput.getNombre());
            model.setVidaUtil(modelInput.getVidaUtil());
            model.setVigente(modelInput.getVigente());

            Model updated = modelRepository.save(model);
            ModelInput input = new ModelInput(
                    updated.getId(),
                    updated.getBrand().getId(),
                    updated.getNombre(),
                    updated.getVidaUtil(),
                    updated.getVigente()
            );
            return input;
        }
        return null;
    }

    @Override
    public List<ModelOutput> getAll() {

        List<Model> Models = (List<Model>) modelRepository.getAll();

        List<ModelOutput> outputs = new ArrayList<ModelOutput>();
        Models.forEach(m-> {
            ModelOutput model = new ModelOutput(
                    m.getId(),
                    m.getBrand().getId(),
                    m.getBrand().getNombre(),
                    m.getNombre(),
                    m.getVidaUtil(),
                    m.getVigente()
            );
            outputs.add(model);
        });
        if (outputs.isEmpty()) {
            return new ArrayList<ModelOutput>();
        }
        return outputs;
    }

    @Override
    public ModelOutput getById(Long id) {
        Optional<Model> ModelData = modelRepository.getById(id);
        if (ModelData.isPresent()) {
            Model model = ModelData.get();
            ModelOutput output = new ModelOutput(
                    model.getId(),
                    model.getBrand().getId(),
                    model.getBrand().getNombre(),
                    model.getNombre(),
                    model.getVidaUtil(),
                    model.getVigente()
            );
            return output;
        }
        return null;
    }
}

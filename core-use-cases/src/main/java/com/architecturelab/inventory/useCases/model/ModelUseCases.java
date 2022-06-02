package com.architecturelab.inventory.useCases.model;

import com.architecturelab.inventory.core.domain.model.ModelInput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelUseCases {

    public ModelInput create(ModelInput ModelInput);

    public ModelInput update(ModelInput modelInput);

    public List<ModelInput> getAll();

    public ModelInput getById(Long id);
}

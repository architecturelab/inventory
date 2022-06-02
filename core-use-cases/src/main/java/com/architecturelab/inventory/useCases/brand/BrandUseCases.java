package com.architecturelab.inventory.useCases.brand;


import com.architecturelab.inventory.core.domain.brand.BrandInput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandUseCases {

    public BrandInput create(BrandInput brandInput);

    public BrandInput update(BrandInput brandt);

    public List<BrandInput> getAll();

    public BrandInput getById(Long id);
}

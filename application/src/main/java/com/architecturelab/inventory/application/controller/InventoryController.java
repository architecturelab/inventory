package com.architecturelab.inventory.application.controller;

import com.architecturelab.inventory.core.domain.brand.BrandInput;
import com.architecturelab.inventory.core.domain.dependency.DependencyInput;
import com.architecturelab.inventory.core.domain.item.ItemInput;
import com.architecturelab.inventory.core.domain.model.ModelInput;
import com.architecturelab.inventory.core.domain.type.TypeInput;
import com.architecturelab.inventory.infra.jpa.domain.Dependency;
import com.architecturelab.inventory.useCases.brand.BrandUseCases;
import com.architecturelab.inventory.useCases.dependency.DependencyUseCases;
import com.architecturelab.inventory.useCases.item.ItemInputUseCases;
import com.architecturelab.inventory.useCases.item.ItemOutputUseCases;
import com.architecturelab.inventory.useCases.model.ModelUseCases;
import com.architecturelab.inventory.useCases.type.TypeUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private ItemInputUseCases itemInputUseCases;

    @Autowired
    private ItemOutputUseCases itemOutputUseCases;

    @Autowired
    private BrandUseCases brandUseCases;

    @Autowired
    private ModelUseCases modelUseCases;

    @Autowired
    private TypeUseCases typeUseCases;

    @Autowired
    private DependencyUseCases dependencyUseCases;

    @GetMapping("/items-plain")
    public ResponseEntity<List<ItemInput>> getAllItemsPlain() {
        try {
            List<ItemInput> items = itemInputUseCases.getAll();
            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/items")
    public String getAllItems() {
        //getItemOutputUseCase.execute();
        return "Get items";
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ItemInput> getItemById(@PathVariable Long id) {
        try {
            ItemInput item = itemInputUseCases.getById(id);
            if (item != null) {
                return new ResponseEntity<>(item, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/item")
    public ResponseEntity<ItemInput> createItem(@RequestBody ItemInput itemInput) {
        try {
            ItemInput _item = itemInputUseCases.create(itemInput);
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/item")
    public ResponseEntity<ItemInput> updateItem(@RequestBody ItemInput itemInput) {
        try {
            ItemInput item = itemInputUseCases.update(itemInput);
            if (item !=null) {
                return new ResponseEntity<>(item, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Brand

    @GetMapping("/brand/{id}")
    public ResponseEntity<BrandInput> getBrandById(@PathVariable Long id) {
        try {
            BrandInput brandInput = brandUseCases.getById(id);
            if (brandInput != null) {
                return new ResponseEntity<>(brandInput, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/brand")
    public ResponseEntity<BrandInput> createBrand(@RequestBody BrandInput brandInput) {
        try {
            BrandInput _brandInput = brandUseCases.create(brandInput);
            return new ResponseEntity<>(_brandInput, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/brand")
    public ResponseEntity<BrandInput> updateBrand(@RequestBody BrandInput brandInput) {
        try {
            BrandInput _brandInput = brandUseCases.update(brandInput);
            if (_brandInput !=null) {
                return new ResponseEntity<>(_brandInput, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/brands")
    public ResponseEntity<List<BrandInput>> getAllBrands() {
        try {
            List<BrandInput> brandInputs = brandUseCases.getAll();
            if (brandInputs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(brandInputs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Model

    @GetMapping("/model/{id}")
    public ResponseEntity<ModelInput> getModelById(@PathVariable Long id) {
        try {
            ModelInput modelInput = modelUseCases.getById(id);
            if (modelInput != null) {
                return new ResponseEntity<>(modelInput, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/model")
    public ResponseEntity<ModelInput> createModel(@RequestBody ModelInput modelInput) {
        try {
            ModelInput _modelInput = modelUseCases.create(modelInput);
            return new ResponseEntity<>(_modelInput, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("model")
    public ResponseEntity<ModelInput> updateModel(@RequestBody ModelInput modelInput) {
        try {
            ModelInput _modelInput = modelUseCases.update(modelInput);
            if (_modelInput !=null) {
                return new ResponseEntity<>(_modelInput, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/models")
    public ResponseEntity<List<ModelInput>> getAllModels() {
        try {
            List<ModelInput> modelInputs = modelUseCases.getAll();
            if (modelInputs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(modelInputs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Type

    @GetMapping("/type/{id}")
    public ResponseEntity<TypeInput> getTypeById(@PathVariable Long id) {
        try {
            TypeInput typeInput = typeUseCases.getById(id);
            if (typeInput != null) {
                return new ResponseEntity<>(typeInput, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/type")
    public ResponseEntity<TypeInput> createType(@RequestBody TypeInput typeInput) {
        try {
            TypeInput _typeInput = typeUseCases.create(typeInput);
            return new ResponseEntity<>(_typeInput, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("type")
    public ResponseEntity<TypeInput> updateType(@RequestBody TypeInput typeInput) {
        try {
            TypeInput _typeInput = typeUseCases.update(typeInput);
            if (_typeInput !=null) {
                return new ResponseEntity<>(_typeInput, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/types")
    public ResponseEntity<List<TypeInput>> getAllTypes() {
        try {
            List<TypeInput> typeInputs = typeUseCases.getAll();
            if (typeInputs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(typeInputs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Type

    @GetMapping("/dependency/{id}")
    public ResponseEntity<DependencyInput> getDependencyById(@PathVariable Long id) {
        try {
            DependencyInput dependencyInput = dependencyUseCases.getById(id);
            if (dependencyInput != null) {
                return new ResponseEntity<>(dependencyInput, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/dependency")
    public ResponseEntity<DependencyInput> createDependency(@RequestBody DependencyInput dependencyInput) {
        try {
            DependencyInput _typeInput = dependencyUseCases.create(dependencyInput);
            return new ResponseEntity<>(_typeInput, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("dependency")
    public ResponseEntity<DependencyInput> updateDependency(@RequestBody DependencyInput dependencyInput) {
        try {
            DependencyInput _dependencyInput = dependencyUseCases.update(dependencyInput);
            if (_dependencyInput !=null) {
                return new ResponseEntity<>(_dependencyInput, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dependencies")
    public ResponseEntity<List<DependencyInput>> getAllDependencies() {
        try {
            List<DependencyInput> dependencyInputs = dependencyUseCases.getAll();
            if (dependencyInputs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(dependencyInputs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

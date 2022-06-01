package com.architecturelab.inventory.core.domain.dependency;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DependencyInput {

    private Long dependenciaId;

    private String nombre;

    private String vigente;

}
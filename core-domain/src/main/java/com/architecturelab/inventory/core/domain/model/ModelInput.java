package com.architecturelab.inventory.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModelInput {

    private Long modeloId;

    private Long marcaId;

    private String nombre;

    private String vidaUtil;

    private String vigente;

}
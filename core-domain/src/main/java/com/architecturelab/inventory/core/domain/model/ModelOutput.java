package com.architecturelab.inventory.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModelOutput {

    private Long modeloId;

    private Long marcaId;

    private String marca;

    private String nombre;

    private String vidaUtil;

    private String vigente;

}
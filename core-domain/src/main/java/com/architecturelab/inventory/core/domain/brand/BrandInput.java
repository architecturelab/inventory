package com.architecturelab.inventory.core.domain.brand;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BrandInput {

    private Long marcaId;

    private String nombre;

    private String vidaUtil;

    private String vigente;

}
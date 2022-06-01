package com.architecturelab.inventory.core.domain.type;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TypeInput {

    private Long claseId;

    private String nombre;

    private String vidaUtil;

    private String vigente;

}
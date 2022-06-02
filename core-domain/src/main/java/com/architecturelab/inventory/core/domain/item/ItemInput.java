package com.architecturelab.inventory.core.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ItemInput {

    private Long itemId;

    private Long claseId;

    private Long marcaId;

    private Long modeloId;

    private String serial;

    private Date fechaIngreso;

    private Date fechaFinalGarantia;

    private Double valor;

    private Date fechaBaja;

    private String estado;

    private String observacion;

    private Long dependenciaId;

    private String usuarioCreacion;

    private Date fechaCreacion;

    private String usuarioModifica;
}

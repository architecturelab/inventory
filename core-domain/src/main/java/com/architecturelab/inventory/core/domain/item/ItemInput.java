package com.architecturelab.inventory.core.domain.item;

import lombok.Data;

import java.util.Date;

@Data
public class ItemInput {

    private Integer claseId;

    private Integer marcaId;

    private Integer modeloId;

    private String serial;

    private Date fechaIngreso;

    private Date fechaFinalGarantia;

    private Double valor;

    private Date fechaBaja;

    private String estado;

    private String observacion;

    private String dependenciaId;

    private String usuarioCreacion;

    private Date fechaCreacion;

    private String usuarioModifica;
}

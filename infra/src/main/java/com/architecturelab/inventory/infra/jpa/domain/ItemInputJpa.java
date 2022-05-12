package com.architecturelab.inventory.infra.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemInputJpa {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer activoId;

    @Column(name = "clase_id")
    private Integer claseId;

    @Column(name = "marca_id")
    private Integer marcaId;

    @Column(name = "modelo_id")
    private Integer modeloId;

    @Column(name = "serial")
    private String serial;

    @Column(name = "fecha_igreso")
    private Date fechaIngreso;

    @Column(name = "fecha_final_garantia")
    private Date fechaFinalGarantia;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "fecha_baja")
    private Date fechaBaja;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "dependecia_id")
    private String dependenciaId;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "usuario_modifica")
    private String usuarioModifica;
}

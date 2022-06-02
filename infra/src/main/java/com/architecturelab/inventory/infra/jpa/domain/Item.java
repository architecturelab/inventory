package com.architecturelab.inventory.infra.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "inve_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Item extends BaseEntity {

    public Item(Long id, Type type, Brand brand, Model model, String serial, Date fechaIngreso, Date fechaFinalGarantia, Double valor, Date fechaBaja, String estado, String observacion, Dependency dependency, String usuarioCreacion, Date fechaCreacion, String usuarioModifica) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.fechaIngreso = fechaIngreso;
        this.fechaFinalGarantia = fechaFinalGarantia;
        this.valor = valor;
        this.fechaBaja = fechaBaja;
        this.estado = estado;
        this.observacion = observacion;
        this.dependency = dependency;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModifica = usuarioModifica;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Model model;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Dependency dependency;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "usuario_modifica")
    private String usuarioModifica;
}

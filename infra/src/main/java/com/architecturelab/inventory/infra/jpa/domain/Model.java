package com.architecturelab.inventory.infra.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inve_modelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Model extends BaseEntity {

    public Model(Long id) {
        this.id = id;
    }

    public Model(Long id, Brand brand, String nombre, String vidaUtil, String vigente) {
        this.id = id;
        this.brand = brand;
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
        this.vigente = vigente;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Brand brand;

    @Column(name="nombre")
    private String nombre;

    @Column(name="vida_util")
    private String vidaUtil;

    @Column(name="vigente")
    private String vigente;
}

package com.architecturelab.inventory.infra.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inve_marca")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Brand extends BaseEntity {

    public Brand(Long id) {
        this.id = id;
    }

    public Brand(Long id, String nombre, String vidaUtil, String vigente) {
        this.id = id;
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
        this.vigente = vigente;
    }

    @Column(name="nombre")
    private String nombre;

    @Column(name="vida_util")
    private String vidaUtil;

    @Column(name="vigente")
    private String vigente;
}

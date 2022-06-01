package com.architecturelab.inventory.infra.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inve_dependencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Dependency extends BaseEntity {

    public Dependency(Long id) {
        this.id = id;
    }

    public Dependency(Long id, String nombre, String vigente) {
        this.id = id;
        this.nombre = nombre;
        this.vigente = vigente;
    }

    @Column(name="nombre")
    private String nombre;

    @Column(name="vigente")
    private String vigente;
}

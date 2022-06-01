package com.architecturelab.inventory.infra.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
public abstract class BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.TABLE)
    protected Long id;
}

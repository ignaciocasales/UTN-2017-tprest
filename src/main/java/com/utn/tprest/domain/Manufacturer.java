package com.utn.tprest.domain;

import javax.persistence.*;

/**
 * Created by ignacio on 5/31/17.
 * <p>
 * Clase Manufacturer.
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "Manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String description;

    public Manufacturer() {
    }

    public Manufacturer(String description) {
        this.description = description;
    }

    public Manufacturer(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

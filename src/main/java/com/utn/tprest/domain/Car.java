package com.utn.tprest.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ignacio on 5/31/17.
 * <p>
 * Clase Car.
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue
    private long id;

    private String model;

    private String km;

    private String plate;

    private Date year;
    @OneToOne
    private Manufacturer manufacturer;

    public Car() {
    }

    public Car(String model, String km, String plate, Date year, Manufacturer manufacturer) {
        this.model = model;
        this.km = km;
        this.plate = plate;
        this.year = year;
        this.manufacturer = manufacturer;
    }

    public Car(Integer id, String model, String km, String plate, Date year, Manufacturer manufacturer) {
        this.id = id;
        this.model = model;
        this.km = km;
        this.plate = plate;
        this.year = year;
        this.manufacturer = manufacturer;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}

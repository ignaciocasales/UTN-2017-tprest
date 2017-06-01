package com.utn.tprest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.tprest.domain.Manufacturer;

/**
 * Created by ignacio on 6/1/17.
 * <p>
 * CarWrapper.
 */
@SuppressWarnings("unused")
public class CarWrapper {

    @JsonProperty
    private long id;
    @JsonProperty
    private String model;
    @JsonProperty
    private String km;
    @JsonProperty
    private String plate;
    @JsonProperty
    private String year;
    @JsonProperty
    private Manufacturer manufacturer;

    public void setId(long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}

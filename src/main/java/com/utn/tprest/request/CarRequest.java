package com.utn.tprest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.tprest.domain.Manufacturer;

/**
 * Created by ignacio on 6/1/17.
 * <p>
 * Car Request.
 */
public class CarRequest {

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

    public String getModel() {
        return model;
    }

    public String getKm() {
        return km;
    }

    public String getPlate() {
        return plate;
    }

    public String getYear() {
        return year;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }
}

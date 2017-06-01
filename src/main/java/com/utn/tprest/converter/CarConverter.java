package com.utn.tprest.converter;

import com.utn.tprest.domain.Car;
import com.utn.tprest.response.CarWrapper;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by ignacio on 6/1/17.
 * <p>
 * CarConverter.
 */
@Component
public class CarConverter {

    public CarConverter() {
    }

    public CarWrapper convert(Car car) {
        CarWrapper c = new CarWrapper();

        c.setId(car.getId());
        c.setModel(car.getModel());
        c.setKm(car.getKm());
        c.setPlate(car.getPlate());

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
        c.setYear(sdf.format(car.getYear()));

        c.setManufacturer(car.getManufacturer());

        return c;
    }
}

package com.utn.tprest.controllers;

import com.google.common.collect.Lists;
import com.utn.tprest.converter.CarConverter;
import com.utn.tprest.domain.Car;
import com.utn.tprest.persistence.CarRepository;
import com.utn.tprest.request.CarRequest;
import com.utn.tprest.response.CarWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ignacio on 5/31/17.
 * <p>
 * Car Controller.
 */
@Controller
@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarConverter carConverter;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<CarWrapper>> all() {

        Iterable<Car> carsIterable = carRepository.findAll();

        List<Car> carsList = Lists.newArrayList(carsIterable);

        if (carsList.size() > 0) {
            return new ResponseEntity<>(this.convertList(carsList), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity store(@RequestBody CarRequest request) {
        try {
            Car c = new Car();

            c.setModel(request.getModel());
            c.setKm(request.getKm());
            c.setPlate(request.getPlate());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            c.setYear(sdf.parse(request.getYear()));
            c.setManufacturer(request.getManufacturer());

            carRepository.save(c);

            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<CarWrapper> showById(@PathVariable("id") long id) {
        Car c = carRepository.findOne(id);

        if (c != null) {
            CarWrapper cw = carConverter.convert(c);
            return new ResponseEntity<>(cw, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/car/man/{description}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<CarWrapper>> showByManufacturer(@PathVariable("description") String description) {
        Iterable<Car> carsIterable = carRepository.findAll();

        List<Car> carsList = Lists.newArrayList(carsIterable);

        if (carsList.size() > 0) {
            carsList.removeIf(value -> !value.getManufacturer().getDescription().equals(description));

            return new ResponseEntity<>(this.convertList(carsList), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private List<CarWrapper> convertList(List<Car> cars) {
        List<CarWrapper> carWrapperList = new ArrayList<>();
        for (Car c : cars) {
            carWrapperList.add(carConverter.convert(c));
        }
        return carWrapperList;
    }
}

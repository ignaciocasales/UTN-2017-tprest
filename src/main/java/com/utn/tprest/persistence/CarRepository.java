package com.utn.tprest.persistence;

import com.utn.tprest.domain.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ignacio on 6/1/17.
 * <p>
 * This is the repository interface, this will be automatically implemented by Spring
 * in a bean with the same name with changing case The bean name will be carRepository.
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}

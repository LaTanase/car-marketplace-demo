package com.laurentiutanase.carmarketplacedemo.model;

import com.laurentiutanase.carmarketplacedemo.openapi.model.Car;

import java.util.List;

/**
 * Car Data Access Object
 *
 * Translates between Open Api Car and Persistence Car
 */
public interface CarEntityDao {
    /**
     * Transformers
     */
    CarEntity toEntity(Car car);

    Car fromEntity(CarEntity carEntity);

    List<Car> fromEntityList(List<CarEntity> carEntities);

    /**
     * CRUD
     */
    CarEntity get(String id);

    List<CarEntity> getAll();

    void save(CarEntity carEntity);
}

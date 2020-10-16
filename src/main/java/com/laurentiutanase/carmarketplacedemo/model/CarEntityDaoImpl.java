package com.laurentiutanase.carmarketplacedemo.model;

import com.laurentiutanase.carmarketplacedemo.openapi.model.Car;
import com.laurentiutanase.carmarketplacedemo.repository.CarRepository;
import com.laurentiutanase.carmarketplacedemo.service.exception.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarEntityDaoImpl implements CarEntityDao {

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarEntity toEntity(Car car) {
        return new CarEntity.CarEntityBuilder()
                .make(car.getMake())
                .model(car.getModel())
                .year(car.getYear())
                .price(car.getPrice())
                .color(car.getColor())
                .fuelType(car.getFuelType())
                .build();
    }

    @Override
    public Car fromEntity(CarEntity carEntity) {
        Car car = new Car();
        car.setId(car.getId());
        car.setMake(carEntity.getMake());
        car.setModel(carEntity.getModel());
        car.setYear(carEntity.getYear());
        car.setPrice(carEntity.getPrice());
        car.setColor(carEntity.getColor());
        car.setFuelType(carEntity.getFuelType());
        return car;
    }

    @Override
    public List<Car> fromEntityList(List<CarEntity> carEntities) {
        return carEntities.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CarEntity get(String id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(
                "Failed to find car with id: " + id + ". The searched resource does not exist!"));
    }

    @Override
    public List<CarEntity> getAll() {
        return carRepository.findAll();
    }

    @Override
    public void save(CarEntity carEntity) {
        carRepository.save(carEntity);
    }
}

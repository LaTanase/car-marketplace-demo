package com.laurentiutanase.carmarketplacedemo.model;

import com.laurentiutanase.carmarketplacedemo.openapi.model.Car;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "car")
@AllArgsConstructor @NoArgsConstructor @Setter @Getter @Builder
public class CarEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Car.FuelTypeEnum fuelType;

}

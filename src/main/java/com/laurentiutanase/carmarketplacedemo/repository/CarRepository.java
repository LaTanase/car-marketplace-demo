package com.laurentiutanase.carmarketplacedemo.repository;

import com.laurentiutanase.carmarketplacedemo.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, String>,
        JpaSpecificationExecutor<CarEntity> {
}

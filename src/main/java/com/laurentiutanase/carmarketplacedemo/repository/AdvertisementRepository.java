package com.laurentiutanase.carmarketplacedemo.repository;

import com.laurentiutanase.carmarketplacedemo.model.AdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, String>,
        JpaSpecificationExecutor<AdvertisementEntity> {
}

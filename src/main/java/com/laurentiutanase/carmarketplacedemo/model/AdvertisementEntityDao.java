package com.laurentiutanase.carmarketplacedemo.model;

import com.laurentiutanase.carmarketplacedemo.openapi.model.Advertisement;

import java.util.List;

/**
 * Advertisement Data Access Object
 *
 * Translates between Open Api Advertisement and Persistence Advertisement
 */
public interface AdvertisementEntityDao {
    /**
     * Transformers
     */
    AdvertisementEntity toEntity(Advertisement advertisement);

    Advertisement fromEntity(AdvertisementEntity advertisementEntity);

    List<Advertisement> fromEntityList(List<AdvertisementEntity> advertisementEntities);

    /**
     * CRUD
     */
    AdvertisementEntity get(String id);

    List<AdvertisementEntity> getAll();

    void save(AdvertisementEntity advertisementEntity);
}

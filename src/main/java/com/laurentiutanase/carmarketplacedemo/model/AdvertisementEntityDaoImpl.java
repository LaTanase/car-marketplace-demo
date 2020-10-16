package com.laurentiutanase.carmarketplacedemo.model;

import com.laurentiutanase.carmarketplacedemo.openapi.model.Advertisement;
import com.laurentiutanase.carmarketplacedemo.repository.AdvertisementRepository;
import com.laurentiutanase.carmarketplacedemo.repository.CarRepository;
import com.laurentiutanase.carmarketplacedemo.repository.UserRepository;
import com.laurentiutanase.carmarketplacedemo.service.exception.AdvertisementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdvertisementEntityDaoImpl implements AdvertisementEntityDao {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private CarEntityDao carEntityDao;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserEntityDao userEntityDao;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AdvertisementEntity toEntity(Advertisement advertisement) {
        return new AdvertisementEntity.AdvertisementEntityBuilder()
                .title(advertisement.getTitle())
                .description(advertisement.getDescription())
                .publisherId(advertisement.getPublisher().getId())
                .carId(advertisement.getCar().getId())
                .build();
    }

    @Override
    public Advertisement fromEntity(AdvertisementEntity advertisementEntity) {
        Advertisement advertisement = new Advertisement();
        advertisement.setId(advertisementEntity.getId());
        advertisement.setTitle(advertisementEntity.getTitle());
        advertisement.setDescription(advertisementEntity.getDescription());
        advertisement.setPublisher(userEntityDao.fromEntity(userRepository.findById(advertisementEntity.getPublisherId().toString()).get()));
        advertisement.setCar(carEntityDao.fromEntity(carRepository.findById(advertisementEntity.getCarId().toString()).get()));
        return advertisement;
    }

    @Override
    public List<Advertisement> fromEntityList(List<AdvertisementEntity> advertisementEntities) {
        return advertisementEntities.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AdvertisementEntity get(String id) {
        return advertisementRepository.findById(id).orElseThrow(() -> new AdvertisementNotFoundException(
                "Failed to find advertisement with id: " + id + ". The searched resource does not exist!"));
    }

    @Override
    public List<AdvertisementEntity> getAll() {
        return advertisementRepository.findAll();
    }

    @Override
    public void save(AdvertisementEntity advertisementEntity) {
        advertisementRepository.save(advertisementEntity);
    }
}

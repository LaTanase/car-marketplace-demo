package com.laurentiutanase.carmarketplacedemo;


import com.laurentiutanase.carmarketplacedemo.openapi.AdvertisementApi;
import com.laurentiutanase.carmarketplacedemo.openapi.model.Advertisement;
import com.laurentiutanase.carmarketplacedemo.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AdvertisementController implements AdvertisementApi {

    @Autowired
    private AdvertisementService advertisementService;

    @Override
    public ResponseEntity<Advertisement> createAdvertisement(Advertisement body){
        Advertisement advertisement = advertisementService.addAdvertisement(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(advertisement);
    }

}

package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.restaurant.RestaurantDtoR;
import com.generation.javeat.model.dto.restaurant.RestaurantDtoWFull;
import com.generation.javeat.model.entities.Restaurant;
import com.generation.javeat.model.repositories.RestaurantRepository;

@Service
public class RestaurantConverter {

    @Autowired
    RestaurantRepository rRepo;

    public Restaurant dtoRToRestaurant(RestaurantDtoR dto) {

        return Restaurant
                .builder()
                .id(dto.getId())
                .phone(dto.getPhone())
                .imgUrl(dto.getImgUrl())
                .openingHour(dto.getOpeningHour())
                .closingHour(dto.getClosingHour())
                .positionX(dto.getPositionX())
                .positionY(dto.getPositionY())
                .maxDeliveryDistance(dto.getMaxDeliveryDistance())
                .deliveryPricePerUnit(dto.getDeliveryPricePerUnit())
                .build();
    }

    public RestaurantDtoWFull RestaurantToDtoWFull(Restaurant r) {

        return RestaurantDtoWFull
                .builder()
                .id(r.getId())
                .phone(r.getPhone())
                .imgUrl(r.getImgUrl())
                .openingHour(r.getOpeningHour())
                .closingHour(r.getClosingHour())
                .positionX(r.getPositionX())
                .positionY(r.getPositionY())
                .maxDeliveryDistance(r.getMaxDeliveryDistance())
                .deliveryPricePerUnit(r.getDeliveryPricePerUnit())
                .foodTypes(r.getFoodTypes())
                .deliveries(r.getDeliveries())
                .menu(r.getMenu())
                .build();
    }
}

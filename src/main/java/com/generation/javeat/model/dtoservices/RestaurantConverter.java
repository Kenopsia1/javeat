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

    /**
     * Converte un DTO in un oggetto di tipo Restaurant.
     * 
     * @param dto - L'oggetto RestaurantDtoR da convertire.
     * @return Restaurant - L'entità Restaurant risultante dalla conversione.
     */
    public Restaurant dtoRToRestaurant(RestaurantDtoR dto){
        return Restaurant
                .builder()
                .id(dto.getId())
                .name(dto.getName())
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

    /**
     * Converte un Restaurant in un oggetto RestaurantDtoWFull.
     * 
     * @param e - L'oggetto Restaurant da convertire.
     * @return RestaurantDtoWFull - L'entità RestaurantDtoWFull risultante dalla conversione.
     */
    public RestaurantDtoWFull restaurantToDtoWFull(Restaurant e){
        return RestaurantDtoWFull
                .builder()
                .id(e.getId())
                .name(e.getName())
                .phone(e.getPhone())
                .imgUrl(e.getImgUrl())
                .openingHour(e.getOpeningHour())
                .closingHour(e.getClosingHour())
                .positionX(e.getPositionX())
                .positionY(e.getPositionY())
                .maxDeliveryDistance(e.getMaxDeliveryDistance())
                .deliveryPricePerUnit(e.getDeliveryPricePerUnit())
                .foodTypes(e.getFoodTypes())
                .deliveries(e.getDeliveries())
                .menu(e.getMenu())
                .build();
    }

    /**
     * Converte un DTO RestaurantDtoWFull in un'entità Restaurant.
     * 
     * @param dto - Il DTO RestaurantDtoWFull da convertire.
     * @return Restaurant - L'entità Restaurant risultante dalla conversione.
     */
    public Restaurant dtoWFullToRestaurant(RestaurantDtoWFull dto){
        return new Restaurant() {{
                setName(dto.getName());
                setPhone(dto.getPhone());
                setImgUrl(dto.getImgUrl());
                setOpeningHour(dto.getOpeningHour());
                setClosingHour(dto.getClosingHour());
                setMaxDeliveryDistance(dto.getMaxDeliveryDistance());
                setDeliveryPricePerUnit(dto.getDeliveryPricePerUnit());
                setPositionX(dto.getPositionX());
                setPositionY(dto.getPositionY());
            }};
    }
}

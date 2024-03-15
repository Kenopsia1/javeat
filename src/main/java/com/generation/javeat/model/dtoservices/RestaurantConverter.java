package com.generation.javeat.model.dtoservices;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.restaurant.RestaurantDtoR;
import com.generation.javeat.model.dto.restaurant.RestaurantDtoWDist;
import com.generation.javeat.model.dto.restaurant.RestaurantDtoWFull;
import com.generation.javeat.model.entities.Restaurant;
import com.generation.javeat.model.entities.User;
import com.generation.javeat.model.repositories.RestaurantRepository;
import com.generation.javeat.model.repositories.UserRepository;

@Service
public class RestaurantConverter {

    @Autowired
    RestaurantRepository rRepo;
    @Autowired
    UserRepository uRepo;

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
                .isOpen(isOpen(e))
                .build();
    }

    /**
     * Converte un Restaurant in un oggetto RestaurantDtoWDist.
     * 
     * @param e,u - L'oggetto Restaurant da convertire e l'id dell'user loggato
     * @return RestaurantDtoWDist - L'entità RestaurantDtoWFull risultante dalla conversione.
     */
    public RestaurantDtoWDist restaurantDtoWDist(Restaurant e, int id_u){
        return RestaurantDtoWDist
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
                .isOpen(isOpen(e))
                .distance(calculateDistance(e, id_u))
                .build();
    }

    /**
     * Converte un DTO RestaurantDtoWFull in un'entità Restaurant.
     * 
     * @param dto - Il DTO RestaurantDtoWFull da convertire.
     * @return Restaurant - L'entità Restaurant risultante dalla conversione.
     */
    public Restaurant dtoWFullToRestaurant(RestaurantDtoWFull dto){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setPhone(dto.getPhone());
        restaurant.setImgUrl(dto.getImgUrl());
        restaurant.setOpeningHour(dto.getOpeningHour());
        restaurant.setClosingHour(dto.getClosingHour());
        restaurant.setMaxDeliveryDistance(dto.getMaxDeliveryDistance());
        restaurant.setDeliveryPricePerUnit(dto.getDeliveryPricePerUnit());
        restaurant.setPositionX(dto.getPositionX());
        restaurant.setPositionY(dto.getPositionY());
        return restaurant;
    }

    private boolean isOpen(Restaurant r){
        LocalTime closing = LocalTime.of(r.getClosingHour(), 0);
        LocalTime opening = LocalTime.of(r.getOpeningHour(), 0);
        return LocalTime.now().isBefore(closing) && LocalTime.now().isAfter(opening);
    }

    private int calculateDistance(Restaurant r, int id_u){
        //d = √(x2 − x1)^2 + (y2 − Y1)^2
        Optional<User> ou = uRepo.findById(id_u);
        User u = ou.get();
        return (int) Math.sqrt(Math.pow(u.getPositionX() - r.getPositionX(), 2) 
        +                      Math.pow(u.getPositionY() - r.getPositionY(), 2));
    }
}


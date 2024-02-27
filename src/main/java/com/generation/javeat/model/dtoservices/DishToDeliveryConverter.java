package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.dishtodelivery.DishToDeliveryDtoR;
import com.generation.javeat.model.dto.dishtodelivery.DishToDeliveryDtoWFull;
import com.generation.javeat.model.entities.DishToDelivery;
import com.generation.javeat.model.repositories.DishToDeliveryRepository;
@Service
public class DishToDeliveryConverter {
    @Autowired
    DishToDeliveryRepository dtdRepo;
    
        public DishToDelivery dtoRToPerson(DishToDeliveryDtoR dto)//R
    {
        // private int id;
        // private int quantity;
        return  DishToDelivery
                .builder()
                .id(dto.getId())
                .quantity(dto.getQuantity())
                .build();
    }

    public DishToDeliveryDtoWFull personToDtoWFull(DishToDelivery d)
    {
        // private Dish dish;
        // private Delivery delivery;
        return  DishToDeliveryDtoWFull
                .builder()
                .id(d.getId())
                .quantity(d.getQuantity())
                .dish(d.getDish())
                .delivery(d.getDelivery())
                .build();
    }
}

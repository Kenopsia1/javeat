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

    public DishToDelivery dtoRToPerson(DishToDeliveryDtoR dto)
    {
        // private int id;
        // private int quantity;
        return  DishToDelivery
                .builder()
                .id(dto.getId())
                .quantity(dto.getQuantity())
                .build();
    }

    public DishToDeliveryDtoWFull personToDtoWFull(DishToDelivery dtd)
    {
        // private Dish dish;
        // private Delivery delivery;
        return  DishToDeliveryDtoWFull
                .builder()
                .id(dtd.getId())
                .quantity(dtd.getQuantity())
                .dish(dtd.getDish())
                .delivery(dtd.getDelivery())
                .build();
    }
}

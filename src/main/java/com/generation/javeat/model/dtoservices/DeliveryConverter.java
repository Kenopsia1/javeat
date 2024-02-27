package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.delivery.DeliveryDtoR;
import com.generation.javeat.model.dto.delivery.DeliveryDtoWFull;
import com.generation.javeat.model.entities.Delivery;
import com.generation.javeat.model.repositories.DeliveryRepository;
@Service
public class DeliveryConverter {
    
    @Autowired
    DeliveryRepository dRepo;

    public Delivery dtoToDelivery(DeliveryDtoR dto) {

        return Delivery
                .builder()
                .id(dto.getId())
                .expected_arrival(dto.getExpected_arrival())
                .distance(dto.getDistance())
                .paymentMethod(dto.getPaymentMethod())
                .notes(dto.getNotes())
                .build();
    }

    public DeliveryDtoWFull deliveryToDtoWFull(Delivery d) {

        return DeliveryDtoWFull
                .builder()
                .id(d.getId())
                .expected_arrival(d.getExpected_arrival())
                .distance(d.getDistance())
                .paymentMethod(d.getPaymentMethod())
                .notes(d.getNotes())
                .user(d.getUser())
                .restaurant(d.getRestaurant())
                .dishesDeliveries(d.getDishesDeliveries())
                .build();
    }

}

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

    public DeliveryDtoWFull deliveryToDtoWFull(Delivery e) {

        return DeliveryDtoWFull
                .builder()
                .id(e.getId())
                .expected_arrival(e.getExpected_arrival())
                .distance(e.getDistance())
                .paymentMethod(e.getPaymentMethod())
                .notes(e.getNotes())
                .user(e.getUser())
                .restaurant(e.getRestaurant())
                .dishesDeliveries(e.getDishesDeliveries())
                .build();
    }

    /**
     * Converte un DTO deliveryDtoWFull in un'entità delivery.
     * 
     * @param dto - Il DTO deliveryDtoWFull da convertire.
     * @return delivery - L'entità delivery risultante dalla conversione.
     */
    public Delivery dtoWFullToDelivery(DeliveryDtoWFull dto){
        Delivery delivery = new Delivery();
        delivery.setId(dto.getId());
        delivery.setExpected_arrival(dto.getExpected_arrival());
        delivery.setDistance(dto.getDistance());
        delivery.setPaymentMethod(dto.getPaymentMethod());
        delivery.setNotes(dto.getNotes());
        return delivery;
    }
}

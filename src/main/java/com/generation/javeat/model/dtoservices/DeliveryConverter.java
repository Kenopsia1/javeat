package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.delivery.DeliveryDtoR;
import com.generation.javeat.model.dto.delivery.DeliveryDtoWFull;
import com.generation.javeat.model.entities.Delivery;
import com.generation.javeat.model.entities.DishToDelivery;
import com.generation.javeat.model.repositories.DeliveryRepository;
@Service
public class DeliveryConverter {
    
    @Autowired
    DeliveryRepository dRepo;

    /**
     * Converte un dto in un oggetto di tipo Delivery.
     * 
     * @param dto - L'oggetto DeliveryDtoR da convertire.
     * @return Delivery - L'entità Delivery risultante dalla conversione.
     */
    public Delivery dtoToDelivery(DeliveryDtoR dto){
        return Delivery
                .builder()
                .id(dto.getId())
                .expected_arrival(dto.getExpected_arrival())
                .distance(dto.getDistance())
                .paymentMethod(dto.getPaymentMethod())
                .notes(dto.getNotes())
                .build();
    }

    /**
     * Converte un Delivery in un oggetto DeliveryDtoWFull.
     * 
     * @param e - L'oggetto Delivery da convertire.
     * @return DeliveryDtoWFull - L'entità DeliveryDtoWFull risultante dalla conversione.
     */
    public DeliveryDtoWFull deliveryToDtoWFull(Delivery e){
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
     * Converte un DTO DeliveryDtoWFull in un'entità Delivery.
     * 
     * @param dto - Il DTO DeliveryDtoWFull da convertire.
     * @return Delivery - L'entità Delivery risultante dalla conversione.
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

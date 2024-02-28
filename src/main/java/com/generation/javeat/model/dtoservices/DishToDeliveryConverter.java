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

    /**
     * Converte un DTO in un oggetto di tipo DishToDelivery.
     * 
     * @param dto - L'oggetto DishToDeliveryDtoR da convertire.
     * @return DishToDelivery - L'entità DishToDelivery risultante dalla conversione.
     */
    public DishToDelivery dtoRToDishToDelivery(DishToDeliveryDtoR dto){
        return  DishToDelivery
                .builder()
                .id(dto.getId())
                .quantity(dto.getQuantity())
                .build();
    }

    /**
     * Converte un DishToDelivery in un oggetto DishToDeliveryDtoWFull.
     * 
     * @param e - L'oggetto DishToDelivery da convertire.
     * @return DishToDeliveryDtoWFull - L'entità DishToDeliveryDtoWFull risultante dalla conversione.
     */
    public DishToDeliveryDtoWFull dishToDeliveryToDtoWFull(DishToDelivery e){
        return  DishToDeliveryDtoWFull
                .builder()
                .id(e.getId())
                .quantity(e.getQuantity())
                .dish(e.getDish())
                .delivery(e.getDelivery())
                .build();
    }

    /**
     * Converte un DTO menuDtoWFull in un'entità menu.
     * 
     * @param dto - Il DTO menuDtoWFull da convertire.
     * @return menu - L'entità menu risultante dalla conversione.
     */
    public DishToDelivery dtoWFullToDDishToDelivery(DishToDeliveryDtoWFull dto){        
        DishToDelivery dishToDelivery = new DishToDelivery();
        dishToDelivery.setId(dto.getId());
        dishToDelivery.setQuantity(dto.getQuantity());
        return dishToDelivery;
    }
}

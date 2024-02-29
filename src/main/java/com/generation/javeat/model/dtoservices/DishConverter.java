package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.dish.DishDtoR;
import com.generation.javeat.model.dto.dish.DishDtoWFull;
import com.generation.javeat.model.entities.Dish;
import com.generation.javeat.model.repositories.DishRepository;
@Service
public class DishConverter {
    
    @Autowired
    DishRepository dRepo;

    /**
     * Converte un DTO in un oggetto di tipo Dish.
     * 
     * @param dto - L'oggetto DishDtoR da convertire.
     * @return Dish - L'entità Dish risultante dalla conversione.
     */
    public Dish dtoRToDish(DishDtoR dto){
        return  Dish
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .build();
    }

    /**
     * Converte un Dish in un oggetto DishDtoWFull.
     * 
     * @param e - L'oggetto Dish da convertire.
     * @return DishDtoWFull - L'entità DishDtoWFull risultante dalla conversione.
     */
    public DishDtoWFull dishToDtoWFull(Dish e){
        return  DishDtoWFull
                .builder()
                .id(e.getId())
                .name(e.getName())
                .category(e.getCategory())
                .price(e.getPrice())
                .deliveries(e.getDeliveries())
                .ingredients(e.getIngredients())
                .menu(e.getMenu())
                .build();
    }

    /**
     * Converte un DTO DishDtoWFull in un'entità Dish.
     * 
     * @param dto - Il DTO DishDtoWFull da convertire.
     * @return Dish - L'entità Dish risultante dalla conversione.
     */
    public Dish dtoWFullToDish(DishDtoWFull dto){
        Dish dish = new Dish();
        dish.setName(dto.getName());
        dish.setCategory(dto.getCategory());
        dish.setPrice(dto.getPrice());
        return dish;
    };
}

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

    public Dish dtoRToDish(DishDtoR dto){
        // private int id;
        // private String name;
        // private String category;
        // private double price;
        return  Dish
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .build();
    }

    public DishDtoWFull dishToDtoWFull(Dish e){
        // private Set<DishToDelivery> deliveries;
        // private List<String> ingredients;
        // private Menu menu;
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
     * Converte un DTO dishDtoWFull in un'entità dish.
     * 
     * @param dto - Il DTO dishDtoWFull da convertire.
     * @return dish - L'entità dish risultante dalla conversione.
     */
    public Dish dtoWFullToDish(DishDtoWFull dto) {
        Dish dish = new Dish();
        dish.setName(dto.getName());
        dish.setCategory(dto.getCategory());
        dish.setPrice(dto.getPrice());
        return dish;
    }
}

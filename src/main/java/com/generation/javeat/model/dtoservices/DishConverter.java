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

    public Dish dtoRToPerson(DishDtoR dto){
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

    public DishDtoWFull personToDtoWFull(Dish d){
        // private Set<DishToDelivery> deliveries;
        // private List<String> ingredients;
        // private Menu menu;
        return  DishDtoWFull
                .builder()
                .id(d.getId())
                .name(d.getName())
                .category(d.getCategory())
                .price(d.getPrice())
                .deliveries(d.getDeliveries())
                .ingredients(d.getIngredients())
                .menu(d.getMenu())
                .build();
    }
}

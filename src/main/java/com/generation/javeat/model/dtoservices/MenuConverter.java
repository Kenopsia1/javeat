package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.menu.MenuDtoR;
import com.generation.javeat.model.dto.menu.MenuDtoWFull;
import com.generation.javeat.model.entities.Menu;
import com.generation.javeat.model.repositories.MenuRepository;
@Service
public class MenuConverter {
    @Autowired
    MenuRepository mRepo;

    public Menu dtoRToMenu(MenuDtoR dto){
        // private int id;
        return  Menu
                .builder()
                .id(dto.getId())
                .build();
    }

    public MenuDtoWFull menuToDtoWFull(Menu e){
        // private Set<Dish> dishes;
        // private Restaurant restaurant;
        return  MenuDtoWFull
                .builder()
                .id(e.getId())
                .dishes(e.getDishes())
                .restaurant(e.getRestaurant())
                .build();
    }
}

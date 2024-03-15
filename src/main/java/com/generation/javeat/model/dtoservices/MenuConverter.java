package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.menu.MenuDtoR;
import com.generation.javeat.model.dto.menu.MenuDToWFull;
import com.generation.javeat.model.entities.Menu;
import com.generation.javeat.model.repositories.MenuRepository;
@Service
public class MenuConverter {
    
    @Autowired
    MenuRepository mRepo;

    /**
     * Converte un DTO in un oggetto di tipo Menu.
     * 
     * @param dto - L'oggetto MenuDtoR da convertire.
     * @return Menu - L'entità Menu risultante dalla conversione.
     */
    public Menu dtoRToMenu(MenuDtoR dto){
        return  Menu
                .builder()
                .id(dto.getId())
                .build();
    }

    /**
     * Converte un Menu in un oggetto MenuDtoWFull.
     * 
     * @param e - L'oggetto Menu da convertire.
     * @return MenuDtoWFull - L'entità MenuDtoWFull risultante dalla conversione.
     */
    public MenuDToWFull menuToDtoWFull(Menu e){
        return  MenuDToWFull
                .builder()
                .id(e.getId())
                .dishes(e.getDishes())
                .restaurant(e.getRestaurant())
                .build();
    }

    /**
     * Converte un DTO menuDtoWFull in un'entità menu.
     * 
     * @param dto - Il DTO menuDtoWFull da convertire.
     * @return menu - L'entità menu risultante dalla conversione.
     */
    public Menu dtoWFullToDMenu(MenuDToWFull dto){
        Menu menu = new Menu();
        menu.setId(dto.getId());
        return menu;
    }
}

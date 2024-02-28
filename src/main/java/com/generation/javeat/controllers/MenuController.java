package com.generation.javeat.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javeat.model.dto.menu.MenuDtoR;
import com.generation.javeat.model.dto.menu.MenuDtoWFull;
import com.generation.javeat.model.dtoservices.MenuConverter;
import com.generation.javeat.model.entities.Menu;
import com.generation.javeat.model.repositories.MenuRepository;
@RestController
public class MenuController {

    @Autowired
    MenuConverter mConv;
    @Autowired
    MenuRepository mRepo;

    @GetMapping("/menus")
    public List<MenuDtoWFull> getAllMenus() 
    {
        return mRepo.findAll()
               .stream()
               .map(e -> mConv.menuToDtoWFull(e))
               .toList();
    }

    /**
     * GET /menus/{id}
     * Restituisce un singolo menu basato sull'ID fornito.
     * 
     * @param id L'ID del menu da ottenere.
     * @return ResponseEntity - Risposta HTTP contenente il menu o un messaggio di errore.
     */
    @GetMapping("/menus/{id}")
    public ResponseEntity<?> getMenuById(@PathVariable Integer id) {
        // Cerca il menu nel database per ID
        Optional<Menu> menuOptional = mRepo.findById(id);

        if (menuOptional.isPresent()) {
            // Se il menu è presente, converte l'entità in un DTO da restituire come risposta
            MenuDtoWFull menuDto = mConv.menuToDtoWFull(menuOptional.get());
            return new ResponseEntity<>(menuDto, HttpStatus.OK);
        } else {
            // Se il menu non è stato trovato, restituisce un messaggio di errore
            return new ResponseEntity<String>("Menu with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * PUT /users/{id}
     * Aggiorna i dati di un user nel database.
     * 
     * @param dto I nuovi dati dell'user.
     * @param id L'ID dell'user da aggiornare.
     * @return UserDtoWFull - DTO aggiornato dell'user completa.
     */
    @PutMapping("/menus/{id}")
    public MenuDtoWFull updateMenu(@RequestBody MenuDtoR dto, @PathVariable Integer id) {
        Menu menu = mRepo.findById(id).orElseThrow();

        // Aggiorna i dati dell'user qui
        // user.setMail(dto.getMail()); 

        return mConv.menuToDtoWFull(mRepo.save(menu));
    }

    /**
     * DELETE /users/{id}
     * Elimina un user dal database basato sull'ID fornito.
     * 
     * @param id L'ID del'user da eliminare.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma dell'eliminazione.
     */
    @DeleteMapping("/menus/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable Integer id) 
    {
        mRepo.deleteById(id);
        return new ResponseEntity<String>("Menu with ID " + id + " was deleted successfully.", HttpStatus.ACCEPTED);
    }
}

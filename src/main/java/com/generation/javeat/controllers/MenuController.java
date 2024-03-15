package com.generation.javeat.controllers;

// import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// import com.generation.javeat.model.dto.menu.MenuDtoR;
import com.generation.javeat.model.dto.menu.MenuDToWFull;
import com.generation.javeat.model.dtoservices.MenuConverter;
import com.generation.javeat.model.entities.Menu;
import com.generation.javeat.model.repositories.MenuRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class MenuController {

    @Autowired
    MenuConverter mConv;
    @Autowired
    MenuRepository mRepo;

    /**
     * GET /menus
      * Restituisce una lista di menus completa.
     * 
     * @return AllDMenus - L'entità menus salvate nel database.
     */
    // @GetMapping("/menus")
    // public List<MenuDtoWFull> getAllMenus(){
    //      return mRepo.findAll()
    //             .stream()
    //             .map(e -> mConv.menuToDtoWFull(e))
    //             .toList();
    // }

    /**
     * GET /menus/{id}
     * Restituisce un singolo menu basato sull'ID fornito.
     * 
     * @param id L'ID del menu da ottenere.
     * @return ResponseEntity - Risposta HTTP contenente il menu o un messaggio di errore.
     */
    @GetMapping("/menus/{id}")
    @Operation(description = "Invio una lista con tutti i menu tramite id")
    @ApiResponses(value = {
        @ApiResponse
        (
            description = "Ho inviato tutti i menu",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDToWFull.class))
        )
    })
    public ResponseEntity<?> getMenuById(@PathVariable @Parameter(description = "l'id menu, non vuoto, un numero positivo") Integer id){
        Optional<Menu> menuOptional = mRepo.findById(id);

        if (menuOptional.isPresent()) {
            MenuDToWFull menuDto = mConv.menuToDtoWFull(menuOptional.get());
            return new ResponseEntity<>(menuDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Menu with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * POST /menus/register
     * Registra un nuovo menu nel sistema.
     * 
     * @param dto - Il DTO contenente i dettagli del nuovo utente.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma della creazione.
     */
    // @PostMapping("/menus/register")
    // public ResponseEntity<?> registermenu(@RequestBody MenuDtoWFull dto){
        
    //     // Converti il DTO in un'entità menu
    //     Menu newmenus = mConv.dtoWFullToDMenu(dto);
    //     // Salva il nuovo utente nel database
    //     @SuppressWarnings("unused")
    //     Menu savedmenu = mRepo.save(newmenus);

    //     // Converte l'entità salvata in un DTO da restituire come risposta
    //     //MenuDtoWFull savedMenuDto = rConv.MenuToDtoWFull(savedmenu);

    //     return new ResponseEntity<String>("Menu was created successfully.", HttpStatus.CREATED);
    // }

    /**
     * PUT /menus/{id}
     * Aggiorna i dati di un menu nel database.
     * 
     * @param dto I nuovi dati dell'menu.
     * @param id L'ID dell'menu da aggiornare.
     * @return menuDtoWFull - DTO aggiornato dell'menu completa.
     */
    // @PutMapping("/menus/{id}")
    // public MenuDtoWFull updateMenu(@RequestBody MenuDtoR dto, @PathVariable Integer id) {
    //     Menu menu = mRepo.findById(id).orElseThrow();

    //     // Aggiorna i dati dell'menu qui
    //     // menu.setMail(dto.getMail()); 

    //     return mConv.menuToDtoWFull(mRepo.save(menu));
    // }

    /**
     * DELETE /menus/{id}
     * Elimina un menu dal database basato sull'ID fornito.
     * 
     * @param id L'ID del'menu da eliminare.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma dell'eliminazione.
     */
    // @DeleteMapping("/menus/{id}")
    // public ResponseEntity<?> deleteMenu(@PathVariable Integer id) 
    // {
    //     mRepo.deleteById(id);
    //     return new ResponseEntity<String>("Menu with ID " + id + " was deleted successfully.", HttpStatus.ACCEPTED);
    // }
}

package com.generation.javeat.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import com.generation.javeat.model.dto.dish.DishDtoWFull;
// import com.generation.javeat.model.dto.dish.DishDtoR;
import com.generation.javeat.model.dtoservices.DishConverter;
import com.generation.javeat.model.entities.Dish;
import com.generation.javeat.model.repositories.DishRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class DishController {

    @Autowired
    DishConverter dConv;
    @Autowired
    DishRepository dRepo;

    /**
     * GET /dishes
      * Restituisce una lista di dishes completa.
     * 
     * @return AllDishes - L'entità dishes salvate nel database.
     */
    // @GetMapping("dishes")
    // public List<DishDtoWFull> getAllDishes(){
    //     return dRepo.findAll()
    //            .stream()
    //            .map(e -> dConv.dishToDtoWFull(e))
    //            .toList();
    // }

    /**
     * GET /dishes/{id}
     * Restituisce un singolo dish basato sull'ID fornito.
     * 
     * @param id L'ID del dish da ottenere.
     * @return ResponseEntity - Risposta HTTP contenente il dish o un messaggio di errore.
     */
    @GetMapping("/dishes/{id}")
    @Operation(description = "Leggo un dish dato il suo id")
    @ApiResponses(value = {
        @ApiResponse
        (
            description = "Ho trovato il dish",
            responseCode = "200",
            useReturnTypeSchema = true,
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = DishDtoWFull.class))
        ),
        @ApiResponse
        (
            description = "Non ho trovato il dish ",
            responseCode = "404",
            content = @Content(mediaType = "text")
        )
    })
    public ResponseEntity<?> getDishById(@PathVariable @Parameter(description = "l'id, non vuoto, un numero positivo") Integer id){
        List<Dish> dishList = dRepo.findByMenuId(id);
        
        if (!dishList.isEmpty()) {
            List<DishDtoWFull> dishDto = dishList.stream()
                                    .map(dish -> dConv.dishToDtoWFull(dish))
                                    .collect(Collectors.toList());
            return new ResponseEntity<>(dishDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Dish with menu_id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * POST /dishes/register
     * Registra un nuovo dish nel sistema.
     * 
     * @param dto - Il DTO contenente i dettagli del nuovo utente.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma della creazione.
     */
    // @PostMapping("/dishes/register")
    // public ResponseEntity<?> registerDish(@RequestBody DishDtoWFull dto){
        
    //     // Converti il DTO in un'entità dish
    //     Dish newDishs = dConv.dtoWFullToDish(dto);
    //     // Salva il nuovo utente nel database
    //     @SuppressWarnings("unused")
    //     Dish savedDish = dRepo.save(newDishs);

    //     // Converte l'entità salvata in un DTO da restituire come risposta
    //     //DishDtoWFull savedDishDto = rConv.DishToDtoWFull(savedDish);

    //     return new ResponseEntity<String>("Dish was created successfully.", HttpStatus.CREATED);
    // }

    /**
     * PUT /dishes/{id}
     * Aggiorna i dati di un dish nel database.
     * 
     * @param dto I nuovi dati del dish.
     * @param id L'ID del dish da aggiornare.
     * @return DishDtoWFull - DTO aggiornato del dish completa.
     */
    // @PutMapping("/dishes/{id}")
    // public DishDtoWFull updateDish(@RequestBody DishDtoR dto, @PathVariable Integer id){
    //     Dish dish = dRepo.findById(id).orElseThrow();

    //     // Aggiorna i dati del dish qui
    //     // dish.setName(dto.getName()); 

    //     return dConv.dishToDtoWFull(dRepo.save(dish));
    // }

    /**
     * DELETE /dishes/{id}
     * Elimina un dish dal database basato sull'ID fornito.
     * 
     * @param id L'ID del'dish da eliminare.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma dell'eliminazione.
     */
    // @DeleteMapping("/dishes/{id}")
    // public ResponseEntity<?> deleteDish(@PathVariable Integer id){
    //     dRepo.deleteById(id);
    //     return new ResponseEntity<String>("Dish with ID " + id + " was deleted successfully.", HttpStatus.ACCEPTED);
    // }
}

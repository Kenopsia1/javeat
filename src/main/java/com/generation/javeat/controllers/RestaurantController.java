package com.generation.javeat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javeat.model.dto.restaurant.RestaurantDtoWFull;
import com.generation.javeat.model.dto.user.UserDtoR;
import com.generation.javeat.model.dtoservices.RestaurantConverter;
import com.generation.javeat.model.entities.Restaurant;
import com.generation.javeat.model.repositories.RestaurantRepository;

@RestController
public class RestaurantController {
    
    @Autowired
    RestaurantConverter rConv;
    @Autowired
    RestaurantRepository rRepo;

    /**
     * GET /restaurants
      * Restituisce una lista di restaurants completa.
     * 
     * @return AllRestaurants - L'entità Restaurants salvate nel database.
     */
    @GetMapping("/restaurants")
    public List<RestaurantDtoWFull> getAllRestaurants() 
    {
        return rRepo.findAll()
               .stream()
               .map(e -> rConv.restaurantToDtoWFull(e))
               .toList();
    }

    /**
     * POST /restaurants/register
     * Registra un nuovo restaurant nel sistema.
     * 
     * @param dto - Il DTO contenente i dettagli del nuovo utente.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma della creazione.
     */
    @PostMapping("/restaurants/register")
    public ResponseEntity<?> registerUser(@RequestBody RestaurantDtoWFull dto) {
        
        // Converti il DTO in un'entità Restaurant
        Restaurant newRestaurants = rConv.dtoWFullToRestaurant(dto);
        // Salva il nuovo utente nel database
        Restaurant savedRestaurantr = rRepo.save(newRestaurants);

        // Converte l'entità salvata in un DTO da restituire come risposta
        //RestaurantDtoWFull savedRestaurantDto = rConv.restaurantToDtoWFull(savedRestaurant);

        return new ResponseEntity<String>("Restaurant was created successfully, please login.", HttpStatus.CREATED);
    }

    /**
     * PUT /restaurants/{id}
     * Aggiorna i dati di un user nel database.
     * 
     * @param dto I nuovi dati del restaurant.
     * @param id L'ID del restaurant da aggiornare.
     * @return RestaurantDtoWFull - DTO aggiornato del restaurant completa.
     */
    @PutMapping("/restaurants/{id}")
    public RestaurantDtoWFull updateRestaurant(@RequestBody UserDtoR dto, @PathVariable Integer id) {
        Restaurant restaurant = rRepo.findById(id).orElseThrow();

        // Aggiorna i dati del restaurant qui
        // Restaurant.setName(dto.getName()); 

        return rConv.restaurantToDtoWFull(rRepo.save(restaurant));
    }

    /**
     * DELETE /restaurants/{id}
     * Elimina un restaurant dal database basato sull'ID fornito.
     * 
     * @param id L'ID del'user da eliminare.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma dell'eliminazione.
     */
    @DeleteMapping("/restaurants/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Integer id) 
    {
        rRepo.deleteById(id);
        return new ResponseEntity<String>("Restaurant with ID " + id + " was deleted successfully.", HttpStatus.ACCEPTED);
    }
}

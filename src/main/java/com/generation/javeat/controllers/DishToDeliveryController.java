package com.generation.javeat.controllers;

// import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// import com.generation.javeat.model.dto.dishtodelivery.DishToDeliveryDtoR;
// import com.generation.javeat.model.dto.dishtodelivery.DishToDeliveryDtoWFull;
import com.generation.javeat.model.dtoservices.DishToDeliveryConverter;
// import com.generation.javeat.model.entities.DishToDelivery;
import com.generation.javeat.model.repositories.DishToDeliveryRepository;

@RestController
public class DishToDeliveryController {

    @Autowired
    DishToDeliveryConverter dtdConv;
    @Autowired
    DishToDeliveryRepository dtdRepo;

    /**
     * GET /dishestodeliveries
      * Restituisce una lista di dishestodeliveries completa.
     * 
     * @return AllDdishestodeliveries - L'entità dishestodeliveries salvate nel database.
     */
    // @GetMapping("/dishestodeliveries")
    // public List<DishToDeliveryDtoWFull> getAlldishestodeliveries(){
    //     return dtdRepo.findAll()
    //            .stream()
    //            .map(e -> dtdConv.dishToDeliveryToDtoWFull(e))
    //            .toList();
    // }

    /**
     * GET /dishestodeliveries/{id}
     * Restituisce un singolo dishToDelivery basato sull'ID fornito.
     * 
     * @param id L'ID del dishToDelivery da ottenere.
     * @return ResponseEntity - Risposta HTTP contenente il dishToDelivery o un messaggio di errore.
     */
    // @GetMapping("/dishestodeliveries/{id}")
    // public ResponseEntity<?> getdishToDeliveryById(@PathVariable Integer id){
    //     Optional<DishToDelivery> dishToDeliveryOptional = dtdRepo.findById(id);

    //     if (dishToDeliveryOptional.isPresent()) {
    //         DishToDeliveryDtoWFull dishToDeliveryDto = dtdConv.dishToDeliveryToDtoWFull(dishToDeliveryOptional.get());
    //         return new ResponseEntity<>(dishToDeliveryDto, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<String>("dishToDelivery with ID " + id + " not found.", HttpStatus.NOT_FOUND);
    //     }
    // }

    /**
     * POST /dishestodeliveries/register
     * Registra un nuovo dishToDelivery nel sistema.
     * 
     * @param dto - Il DTO contenente i dettagli del nuovo utente.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma della creazione.
     */
    // @PostMapping("/dishestodeliveries/register")
    // public ResponseEntity<?> registerdishToDelivery(@RequestBody DishToDeliveryDtoWFull dto){
        
    //     // Converti il DTO in un'entità dishToDelivery
    //     DishToDelivery newdishestodeliveries = dtdConv.dtoWFullToDDishToDelivery(dto);
    //     // Salva il nuovo utente nel database
    //     @SuppressWarnings("unused")
    //     DishToDelivery saveddishToDelivery = dtdRepo.save(newdishestodeliveries);

    //     // Converte l'entità salvata in un DTO da restituire come risposta
    //     //dishToDeliveryDtoWFull saveddishToDeliveryDto = rConv.dishToDeliveryToDtoWFull(saveddishToDelivery);

    //     return new ResponseEntity<String>("DishToDelivery was created successfully.", HttpStatus.CREATED);
    // }

    /**
     * PUT /dishestodeliveries/{id}
     * Aggiorna i dati di un dishToDelivery nel database.
     * 
     * @param dto I nuovi dati del dishToDelivery.
     * @param id L'ID del dishToDelivery da aggiornare.
     * @return dishToDeliveryDtoWFull - DTO aggiornato del dishToDelivery completa.
     */
    // @PutMapping("/dishestodeliveries/{id}")
    // public DishToDeliveryDtoWFull updatedishToDelivery(@RequestBody DishToDeliveryDtoR dto, @PathVariable Integer id){
    //     DishToDelivery dishToDelivery = dtdRepo.findById(id).orElseThrow();

    //     // Aggiorna i dati dell'dishToDelivery qui
    //     // dishToDelivery.setMail(dto.getMail()); 

    //     return dtdConv.dishToDeliveryToDtoWFull(dtdRepo.save(dishToDelivery));
    // }

    /**
     * DELETE /dishestodeliveries/{id}
     * Elimina un dishToDelivery dal database basato sull'ID fornito.
     * 
     * @param id L'ID del'dishToDelivery da eliminare.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma dell'eliminazione.
     */
    // @DeleteMapping("/dishestodeliveries/{id}")
    // public ResponseEntity<?> deletedishToDelivery(@PathVariable Integer id){
    //     dtdRepo.deleteById(id);
    //     return new ResponseEntity<String>("DishToDelivery with ID " + id + " was deleted successfully.", HttpStatus.ACCEPTED);
    // }
}

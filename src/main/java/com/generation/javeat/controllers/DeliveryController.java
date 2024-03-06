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

// import com.generation.javeat.model.dto.delivery.DeliveryDtoR;
// import com.generation.javeat.model.dto.delivery.DeliveryDtoRPost;
// import com.generation.javeat.model.dto.delivery.DeliveryDtoWFull;
import com.generation.javeat.model.dtoservices.DeliveryConverter;
// import com.generation.javeat.model.entities.Delivery;
import com.generation.javeat.model.repositories.DeliveryRepository;

@RestController
public class DeliveryController {
    
    @Autowired
    DeliveryConverter deConv;
    @Autowired
    DeliveryRepository deRepo;

    /**
     * GET /deliveries
      * Restituisce una lista di deliveries completa.
     * 
     * @return AllDDeliveries - L'entità deliveries salvate nel database.
     */
    // @GetMapping("/deliveries")
    // public List<DeliveryDtoWFull> getAllDeliveries(){
    //     return deRepo.findAll()
    //            .stream()
    //            .map(e -> deConv.deliveryToDtoWFull(e))
    //            .toList();
    // }

    /**
     * GET /deliveries/{id}
     * Restituisce un singolo delivery basato sull'ID fornito.
     * 
     * @param id L'ID del delivery da ottenere.
     * @return ResponseEntity - Risposta HTTP contenente il Delivery o un messaggio di errore.
     */
    // @GetMapping("/deliveries/{id}")
    // public ResponseEntity<?> getDeliveryById(@PathVariable Integer id){
    //     Optional<Delivery> DeliveryOptional = deRepo.findById(id);

    //     if (DeliveryOptional.isPresent()) {
    //         DeliveryDtoWFull DeliveryDto = deConv.deliveryToDtoWFull(DeliveryOptional.get());
    //         return new ResponseEntity<>(DeliveryDto, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<String>("Delivery with ID " + id + " not found.", HttpStatus.NOT_FOUND);
    //     }
    // }

    /**
     * POST /deliveries/register
     * Registra un nuovo delivery nel sistema.
     * 
     * @param dto - Il DTO contenente i dettagli del nuovo utente.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma della creazione.
     */
    // @PostMapping("/deliveries/register")
    // public ResponseEntity<?> registerDelivery(@RequestBody DeliveryDtoRPost dto){
        
    //     // Converti il DTO in un'entità delivery
    //     Delivery newDeliverys = deConv.dtoToDelivery(dto);
    //     // Salva il nuovo utente nel database
    //     @SuppressWarnings("unused")
    //     Delivery savedDelivery = deRepo.save(newDeliverys);

    //     // Converte l'entità salvata in un DTO da restituire come risposta
    //     //DeliveryDtoWFull savedDeliveryDto = rConv.DeliveryToDtoWFull(savedDelivery);

    //     return new ResponseEntity<String>("Delivery was created successfully.", HttpStatus.CREATED);
    // }

    /**
     * PUT /deliveries/{id}
     * Aggiorna i dati di un delivery nel database.
     * 
     * @param dto I nuovi dati del delivery.
     * @param id L'ID del delivery da aggiornare.
     * @return DeliveryDtoWFull - DTO aggiornato del delivery completa.
     */
    // @PutMapping("/deliveries/{id}")
    // public DeliveryDtoWFull updateDelivery(@RequestBody DeliveryDtoR dto, @PathVariable Integer id){
    //     Delivery Delivery = deRepo.findById(id).orElseThrow();

    //     // Aggiorna i dati del delivery qui
    //     // delivery.setMail(dto.getMail()); 

    //     return deConv.deliveryToDtoWFull(deRepo.save(Delivery));
    // }

    /**
     * DELETE /deliveries/{id}
     * Elimina un delivery dal database basato sull'ID fornito.
     * 
     * @param id L'ID del delivery da eliminare.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma dell'eliminazione.
     */
    // @DeleteMapping("/deliveries/{id}")
    // public ResponseEntity<?> deleteDelivery(@PathVariable Integer id){
    //     deRepo.deleteById(id);
    //     return new ResponseEntity<String>("Delivery with ID " + id + " was deleted successfully.", HttpStatus.ACCEPTED);
    // }
}

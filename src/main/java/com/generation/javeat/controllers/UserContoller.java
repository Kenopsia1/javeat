package com.generation.javeat.controllers;

import java.util.List;
import java.util.Optional;

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

import com.generation.javeat.model.dto.user.UserDtoLogin;
import com.generation.javeat.model.dto.user.UserDtoR;
import com.generation.javeat.model.dto.user.UserDtoWFull;
import com.generation.javeat.model.dtoservices.UserConverter;
import com.generation.javeat.model.entities.User;
import com.generation.javeat.model.repositories.UserRepository;

@RestController
public class UserContoller {

    @Autowired
    UserConverter uConv;
    @Autowired
    UserRepository uRepo;

    /**
     * GET /users
      * Restituisce una lista di users completa.
     * 
     * @return AllUsers - L'entità Users salvate nel database.
     */
    @GetMapping("/users")
    public List<UserDtoWFull> getAllUsers() 
    {
        return uRepo.findAll()
               .stream()
               .map(e -> uConv.userToDtoWFull(e))
               .toList();
    }

    /**
     * POST /users/login
     * Controlla la presenza di un user nel db.
     * 
     * @return UserFull - L'entità User salvata nel database.
     */
    @PostMapping("/users/login")
    public ResponseEntity<?> login(@RequestBody UserDtoLogin dto ){
        Optional<User> optUser = uRepo.login(dto.getMail(), dto.getPassword());
        if (optUser.isPresent()) {
            return new ResponseEntity<UserDtoWFull>(uConv.userToDtoWFull(optUser.get()),HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("User non trovato!",HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * POST /users/register
     * Registra un nuovo utente nel sistema.
     * 
     * @param dto - Il DTO contenente i dettagli del nuovo utente.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma della creazione.
     */
    @PostMapping("/users/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDtoWFull dto) {
        if (uRepo.existsByMail(dto.getMail())) {
            return new ResponseEntity<String>("Email già registrata. Scegli un'altra email.", HttpStatus.BAD_REQUEST);
        }

        // Converti il DTO in un'entità User
        User newUser = uConv.dtoWFullToUser(dto);
        // Salva il nuovo utente nel database
        User savedUser = uRepo.save(newUser);

        // Converte l'entità salvata in un DTO da restituire come risposta
        // UserDtoWFull savedUserDto = uConv.userToDtoWFull(savedUser);

        return new ResponseEntity<String>("User was created successfully, please login.", HttpStatus.CREATED);
    }


    /**
     * PUT /users/{id}
     * Aggiorna i dati di un user nel database.
     * 
     * @param dto I nuovi dati dell'user.
     * @param id L'ID dell'user da aggiornare.
     * @return UserDtoWFull - DTO aggiornato dell'user completa.
     */
    @PutMapping("/users/{id}")
    public UserDtoWFull updateUser(@RequestBody UserDtoR dto, @PathVariable Integer id) {
        User user = uRepo.findById(id).orElseThrow();

        // Aggiorna i dati dell'user qui
        // user.setMail(dto.getMail()); 

        return uConv.userToDtoWFull(uRepo.save(user));
    }

    /**
     * DELETE /users/{id}
     * Elimina un user dal database basato sull'ID fornito.
     * 
     * @param id L'ID del'user da eliminare.
     * @return ResponseEntity - Risposta HTTP e messaggio di conferma dell'eliminazione.
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) 
    {
        uRepo.deleteById(id);
        return new ResponseEntity<String>("User with ID " + id + " was deleted successfully.", HttpStatus.ACCEPTED);
    }
}

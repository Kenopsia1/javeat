package com.generation.javeat.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javeat.model.dto.user.UserDtoLogin;
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
     * Get /users
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

    
}

package com.generation.javeat.controllers;

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

import com.generation.javeat.model.dto.user.UserDtoBase;
import com.generation.javeat.model.dto.user.UserDtoLogin;
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
     * GET /userlogin
     * Restituisce un user     * 
     * @return List<PersonDtoWNoDocuments> - Lista di DTO delle persone senza documenti.
     */
@PostMapping("/users/login")
    public ResponseEntity<?> login(@RequestBody UserDtoLogin dto ){
        Optional<User> optUser = uRepo.login(dto.getMail(), dto.getPassword());
        if (optUser.isPresent()) {
            return new ResponseEntity<UserDtoLogin>(uConv.dtoRToUserLogin(optUser.get()),HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("User non trovato!",HttpStatus.UNAUTHORIZED);
        }
    }
}

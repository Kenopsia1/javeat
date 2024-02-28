package com.generation.javeat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javeat.model.dtoservices.UserConverter;
import com.generation.javeat.model.repositories.UserRepository;

@RestController
public class UserContoller {

    @Autowired
    UserConverter uConv;
    @Autowired
    UserRepository uRepo;

    /**
     * GET /people
     * Restituisce una lista di persone senza i loro documenti.
     * 
     * @return List<PersonDtoWNoDocuments> - Lista di DTO delle persone senza documenti.
     */
    @GetMapping("/userlogin")
    public List<PersonDtoWNoDocuments> getAllPeopleNoDocuments() {
        return repo.findAll()
                .stream()
                .map(conv::personToDtoWNoDocuments)
                .toList();
    }


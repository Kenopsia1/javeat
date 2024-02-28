package com.generation.javeat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javeat.model.dtoservices.RestaurantConverter;
import com.generation.javeat.model.repositories.RestaurantRepository;

@RestController
public class RestaurantController {
    
    @Autowired
    RestaurantConverter rConv;
    @Autowired
    RestaurantRepository rRepo;
}

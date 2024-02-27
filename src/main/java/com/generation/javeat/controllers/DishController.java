package com.generation.javeat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javeat.model.dtoservices.DishConverter;
import com.generation.javeat.model.repositories.DishRepository;

@RestController
public class DishController {

    @Autowired
    DishConverter dConv;
    @Autowired
    DishRepository dRepo;
}

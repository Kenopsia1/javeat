package com.generation.javeat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javeat.model.dtoservices.DishToDeliveryConverter;
import com.generation.javeat.model.repositories.DishToDeliveryRepository;

@RestController
public class DishToDeliveryController {

    @Autowired
    DishToDeliveryConverter dtdConv;
    @Autowired
    DishToDeliveryRepository dtdRepo;
}

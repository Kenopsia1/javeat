package com.generation.javeat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javeat.model.dtoservices.MenuConverter;
import com.generation.javeat.model.repositories.MenuRepository;

@RestController
public class DeliveryController {
    @Autowired
    MenuConverter mConv;
    @Autowired
    MenuRepository mRepo;
}

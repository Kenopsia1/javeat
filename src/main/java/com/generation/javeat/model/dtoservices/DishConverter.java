package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.repositories.DishRepository;
@Service
public class DishConverter {
    @Autowired
    DishRepository dRepo;
}

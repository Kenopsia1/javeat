package com.generation.javeat.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.repositories.DishRepository;
@Service
public class DishConverter {
    @Autowired
    DishRepository dRepo;
}

package com.generation.javeat.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.repositories.DishToDeliveryRepository;
@Service
public class DishToDeliveryConverter {
    @Autowired
    DishToDeliveryRepository dtdRepo;
}

package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.repositories.DishToDeliveryRepository;
@Service
public class DishToDeliveryConverter {
    @Autowired
    DishToDeliveryRepository dtdRepo;
}

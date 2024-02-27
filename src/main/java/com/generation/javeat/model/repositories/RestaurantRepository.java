package com.generation.javeat.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javeat.model.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

}

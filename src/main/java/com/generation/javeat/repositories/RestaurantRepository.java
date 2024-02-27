package com.generation.javeat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javeat.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

}

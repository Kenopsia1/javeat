package com.generation.javeat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javeat.entities.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer>{

}

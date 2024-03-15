package com.generation.javeat.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.generation.javeat.model.entities.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer>{

 @Query("SELECT d FROM Dish d WHERE d.menu.id = :menuId")
    List<Dish> findByMenuId(@Param("menuId") Integer menuId);


}

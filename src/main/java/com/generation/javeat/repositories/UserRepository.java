package com.generation.javeat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javeat.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

package com.generation.javeat.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.generation.javeat.model.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    @Query(value="SELECT * FROM user WHERE mail= :mail AND password= :password", nativeQuery=true)
    Optional<User> login (@Param("mail") String mail, @Param ("password") String password);

    boolean existsByMail(String mail);
}

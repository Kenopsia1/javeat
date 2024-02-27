package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.user.UserDtoR;
import com.generation.javeat.model.entities.User;
import com.generation.javeat.model.repositories.UserRepository;

@Service
public class UserConverter {
    
    @Autowired
    UserRepository uRepo;

    public User dtoRToUser(UserDtoR dto) {

        return User
                .builder()
                .id(dto.getId())
                .mail(dto.getMail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .positionX(dto.getPositionX())
                .positionY(dto.getPositionY())
                .build();
    }
}

package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.user.UserDtoR;
import com.generation.javeat.model.dto.user.UserDtoWFull;
import com.generation.javeat.model.entities.User;
import com.generation.javeat.model.repositories.UserRepository;

@Service
public class UserConverter {

    @Autowired
    UserRepository uRepo;

    public User dtoRToUser(UserDtoR dto) {

        return User
                .builder()
                .mail(dto.getMail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .positionX(dto.getPositionX())
                .positionY(dto.getPositionY())
                .build();
    }

    public UserDtoWFull userToDtoWFull(User u) {

        return UserDtoWFull
                .builder()
                .id(u.getId())
                .mail(u.getMail())
                .password(u.getPassword())
                .phone(u.getPhone())
                .positionX(u.getPositionX())
                .positionY(u.getPositionY())
                .deliveries(u.getDeliveries())
                .build();

    }
}

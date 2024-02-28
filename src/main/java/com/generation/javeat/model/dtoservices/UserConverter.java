package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.model.dto.user.UserDtoLogin;
import com.generation.javeat.model.dto.user.UserDtoR;
import com.generation.javeat.model.dto.user.UserDtoWFull;
import com.generation.javeat.model.entities.User;
import com.generation.javeat.model.repositories.UserRepository;

@Service
public class UserConverter {

    @Autowired
    UserRepository uRepo;

    public UserDtoLogin dtoRToUserLogin(User e) {

        return UserDtoLogin
                .builder()
                .mail(e.getMail())
                .password(e.getPassword())
                .build();
    }

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

    public UserDtoWFull userToDtoWFull(User e) {

        return UserDtoWFull
                .builder()
                .id(e.getId())
                .mail(e.getMail())
                .password(e.getPassword())
                .phone(e.getPhone())
                .positionX(e.getPositionX())
                .positionY(e.getPositionY())
                .deliveries(e.getDeliveries())
                .build();

    }

    /**
     * Converte un DTO UserDtoWFull in un'entità User.
     * 
     * @param dto - Il DTO UserDtoWFull da convertire.
     * @return User - L'entità User risultante dalla conversione.
     */
    public User dtoWFullToUser(UserDtoWFull dto){
        User user = new User();
        user.setMail(dto.getMail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setPositionX(dto.getPositionX());
        user.setPositionY(dto.getPositionY());
        return user;
    }
}

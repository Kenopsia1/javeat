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

    public User dtoRToUserLogin(User u) {

        return User
                .builder()
                .mail(u.getMail())
                .password(u.getPassword())
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

    /**
     * Converte un DTO UserDtoWFull in un'entità User.
     * 
     * @param dto - Il DTO UserDtoWFull da convertire.
     * @return User - L'entità User risultante dalla conversione.
     */
    public User dtoWFullToUser(UserDtoWFull dto) {
        User user = new User();
        user.setMail(dto.getMail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setPositionX(dto.getPositionX());
        user.setPositionY(dto.getPositionY());
        // Altri campi dell'entità User che potresti voler impostare

        return user;
    }
}

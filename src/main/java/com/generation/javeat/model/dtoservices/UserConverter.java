package com.generation.javeat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javeat.controllers.util.EntityException;
import com.generation.javeat.model.dto.user.UserDtoLogin;
import com.generation.javeat.model.dto.user.UserDtoR;
import com.generation.javeat.model.dto.user.UserDtoWFull;
import com.generation.javeat.model.entities.User;
import com.generation.javeat.model.repositories.UserRepository;

@Service
public class UserConverter {

    @Autowired
    UserRepository uRepo;

    /**
     * Converte un User in un oggetto di tipo UserDtoLogin.
     * 
     * @param e - L'oggetto User da convertire.
     * @return UserDtoLogin - L'entità UserDtoLogin risultante dalla conversione.
     */
    public UserDtoLogin dtoRToUserLogin(User e){
        return UserDtoLogin
                .builder()
                .mail(e.getMail())
                .password(e.getPassword())
                .build();
    }

    /**
     * Converte un DTO in un oggetto di tipo User.
     * 
     * @param dto - L'oggetto UserDtoR da convertire.
     * @return User - L'entità User risultante dalla conversione.
     */
    public User dtoRToUser(UserDtoR dto){
        return User
                .builder()
                .mail(dto.getMail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .positionX(dto.getPositionX())
                .positionY(dto.getPositionY())
                .build();
    }
    
    /**
     * Converte un User in un oggetto UserDtoWFull.
     * 
     * @param e - L'oggetto User da convertire.
     * @return UserDtoWFull - L'entità UserDtoWFull risultante dalla conversione.
     */
    public UserDtoWFull userToDtoWFull(User e){
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
        if(user.isValid())
            return user;
        else {
            throw new EntityException("Errore nella registrazione, ricontrolla i dati inseriti!");
        }
    }
}

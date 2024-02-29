package com.generation.javeat.model.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generation.javeat.controllers.util.EntityException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mail, password, phone;
    private int positionX, positionY;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<Delivery> deliveries;

    
    public void setPositionX(int positionX) {
        if (positionX >= 0 && positionX <= 1000) {
            this.positionX = positionX;
        } else {
            throw new EntityException("positionX deve essere compreso tra 0 e 1000, hai inserito: "+positionX);
        }
    }

    public void setPositionY(int positionY) {
        if (positionY >= 0 && positionY <= 1000) {
            this.positionY = positionY;
        } else {
            throw new EntityException("positionY deve essere compreso tra 0 e 1000, hai inserito: "+positionY);
        }
    }
}

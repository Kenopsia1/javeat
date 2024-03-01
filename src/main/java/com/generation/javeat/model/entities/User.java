package com.generation.javeat.model.entities;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    
    public void setPositionX(int positionX){
        if (positionX >= 0 && positionX <= 100) {
            this.positionX = positionX;
        } else {
            throw new EntityException("positionX deve essere compreso tra 0 e 1000, hai inserito: "+positionX);
        }
    }

    public void setPositionY(int positionY){
        if (positionY >= 0 && positionY <= 100) {
            this.positionY = positionY;
        } else {
            throw new EntityException("positionY deve essere compreso tra 0 e 1000, hai inserito: "+positionY);
        }
    }

    public boolean isValidPassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean isValidEmail(String email){
        Pattern pattern = Pattern
                .compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPhone(String phone){
        Pattern pattern = Pattern
                .compile("^(?:(?:\\+|00)\\d{1,3})?[\\s.-]?\\(?(\\d{3})\\)?[\\s.-]?(\\d{3})[\\s.-]?(\\d{4})$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public boolean isValid(){
        return  isValidEmail(mail) &&
                isValidPassword(password) && 
                isValidPhone(phone) &&
                positionX >= 0 && positionX <= 100 &&
                positionY >= 0 && positionX <= 100;
    }
}

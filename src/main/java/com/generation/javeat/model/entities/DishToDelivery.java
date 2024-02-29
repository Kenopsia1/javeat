package com.generation.javeat.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generation.javeat.controllers.util.EntityException;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishToDelivery {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
 
    public double getPrice(){
    // getPrice() = price x quantity
        return quantity*dish.getPrice();
    }

    public void setQuantity(int quantity) {
        if (quantity != 0 && quantity < 0) {
            throw new EntityException("deliveryPricePerUnit non puo essere minore di 0, hai inserito: " + quantity);
        }
        this.quantity = quantity;
    }
}

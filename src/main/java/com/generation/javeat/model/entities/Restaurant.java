package com.generation.javeat.model.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generation.javeat.controllers.util.EntityException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phone, imgUrl, name;

    private int openingHour, closingHour, positionX, positionY, maxDeliveryDistance;

    private Double deliveryPricePerUnit;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "foodTypes", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "FoodTypes", nullable = false)
    private List<String> foodTypes;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Delivery> deliveries;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public void setPositionX(int positionX) {
        if (positionX >= 0 && positionX <= 100) {
            this.positionX = positionX;
        } else {
            throw new EntityException("positionX deve essere compreso tra 0 e 1000, hai inserito: "+positionX);
        }
    }

    public void setPositionY(int positionY) {
        if (positionY >= 0 && positionY <= 100) {
            this.positionY = positionY;
        } else {
            throw new EntityException("positionY deve essere compreso tra 0 e 1000, hai inserito: "+positionY);
        }
    }

    public void setDeliveryPricePerUnit(Double deliveryPricePerUnit) {
        if (deliveryPricePerUnit != null && deliveryPricePerUnit < 0) {
            throw new EntityException("deliveryPricePerUnit non puo essere minore di 0, hai inserito: " + deliveryPricePerUnit);
        }
        this.deliveryPricePerUnit = deliveryPricePerUnit;
    }
}

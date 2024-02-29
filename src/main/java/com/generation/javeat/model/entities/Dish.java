package com.generation.javeat.model.entities;

import java.util.Set;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generation.javeat.controllers.util.EntityException;

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
import lombok.ToString;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dish {   
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String category;
    private double price;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "ingredients", joinColumns = @JoinColumn(name = "dish_id"))
    @Column(name = "ingredients", nullable = false)
    private List<String> ingredients;

    @JsonIgnore
    @OneToMany(mappedBy = "dish", fetch = FetchType.EAGER)
    private Set<DishToDelivery> deliveries;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public void setPrice(Double price) {
        if (price != 0 && price <= 0) {
            throw new EntityException("Price non puo essere minore di 0, hai inserito: " + price);
        }
        this.price = price;
    }
}

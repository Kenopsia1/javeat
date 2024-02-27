package com.generation.javeat.entities;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.hibernate.mapping.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dish {
    //id int
    //name string
    //category string
    //ingredients List String
    //price double
    //deliveries SetDishToDelivery
    //menu menu
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String category;
    private double price;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
        @CollectionTable(name = "foodTypes", joinColumns = @JoinColumn(name = "restauran_id"))
        @Column(name = "restaurant", nullable = false)
    private List<String> ingredients = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "dishtodeliver", fetch = FetchType.EAGER)
    private Set<DishToDelivery> postedQuests;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;
}

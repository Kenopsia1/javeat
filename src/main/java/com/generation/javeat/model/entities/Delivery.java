package com.generation.javeat.model.entities;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime expected_arrival;

    private int distance;
    private String paymentMethod, notes;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonIgnore
    @OneToMany(mappedBy = "delivery",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<DishToDelivery> dishesDeliveries;

    public double getDishesPrice(){
    // getDishesPrice() = ∑ getPrice()
        return dishesDeliveries.stream().mapToDouble(i -> i.getDish().getPrice()).sum();
    }
    
    public double getRiderRevenue(){
    // getriderevenue() = deliverypriceperunit x distance(getdistance)
        return restaurant.getDeliveryPricePerUnit() * distance;
    }

    public double getTotalPrice(){
    // gettotalprice() = getdishesprice + getriderrevenue()
        return getDishesPrice() + getRiderRevenue();
    }

}

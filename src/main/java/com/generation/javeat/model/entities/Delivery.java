package com.generation.javeat.model.entities;

import java.sql.Date;
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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date expected_arrival;

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
    @OneToMany(mappedBy = "deliveries",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<DishToDelivery> dishesDeliveries;

    public int getDistance(Delivery d){
    //d = √(x2 − x1)^2 + (y2 − Y1)^2
        int deltaX = d.getRestaurant().getPositionX() - d.getUser().getPositionX();
        int deltaY = d.getRestaurant().getPositionY() - d.getUser().getPositionY();
        return (int) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public double getDishesPrice(Delivery d){
    // getDishesPrice() = ∑ getPrice()
        if(d.getDishesDeliveries()==null)
        return 0;

        double res = 0;
        for(DishToDelivery dtd: d.getDishesDeliveries())
            res+=dtd.getPrice(dtd);

        return res;
    }
    
    public double getRiderRevenue(Delivery d){
    // getriderevenue() = deliverypriceperunit x distance(getdistance)
        return d.getRestaurant().getDeliveryPricePerUnit() * d.getDistance();
    }

    public double getTotalPrice(Delivery d){
    // gettotalprice() = getdishesprice+getriderrevenue()
        return d.getDishesPrice(d) + d.getRiderRevenue(d);
    }

}

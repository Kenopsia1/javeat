package com.generation.javeat.dto.delivery;

import java.util.Set;

import com.generation.javeat.entities.DishToDelivery;
import com.generation.javeat.entities.Restaurant;
import com.generation.javeat.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
public class DeliveryDtoWFull {

    private User user;
    private Restaurant restaurant;
    private Set<DishToDelivery> dishesDeliveries;
}

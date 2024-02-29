package com.generation.javeat.model.dto.delivery;

import java.util.Set;

import com.generation.javeat.model.entities.DishToDelivery;
import com.generation.javeat.model.entities.Restaurant;
import com.generation.javeat.model.entities.User;

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
public class DeliveryDtoWFull extends DeliveryDtoBase {
    private User user;
    private Restaurant restaurant;
    private Set<DishToDelivery> dishesDeliveries;
}

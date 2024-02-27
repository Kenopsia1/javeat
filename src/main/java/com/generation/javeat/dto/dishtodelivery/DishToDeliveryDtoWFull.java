package com.generation.javeat.dto.dishtodelivery;

import com.generation.javeat.entities.Delivery;
import com.generation.javeat.entities.Dish;

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
public abstract class DishToDeliveryDtoWFull extends DishToDeliveryDtoBase{
    private Dish dish;
    private Delivery delivery;
}

package com.generation.javeat.model.dto.dishtodelivery;

import com.generation.javeat.model.entities.Delivery;
import com.generation.javeat.model.entities.Dish;

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
public class DishToDeliveryDtoWFull extends DishToDeliveryDtoBase{
    private Dish dish;
    private Delivery delivery;
}

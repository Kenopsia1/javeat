package com.generation.javeat.model.dto.dishtodelivery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class DishToDeliveryDtoR extends DishToDeliveryDtoBase{
    public DishToDeliveryDtoR(){};
}

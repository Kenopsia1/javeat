package com.generation.javeat.dto.restaurant;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class RestaurantDtoR extends RestaurantDtoBase{

    public RestaurantDtoR(){};
}

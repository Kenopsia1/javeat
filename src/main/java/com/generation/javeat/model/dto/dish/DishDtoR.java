package com.generation.javeat.model.dto.dish;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class DishDtoR extends DishDtoBase{
    public DishDtoR(){};
}

package com.generation.javeat.model.dto.dishtodelivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class DishToDeliveryDtoBase {
    private int id;
    private int quantity;
}

package com.generation.javeat.dto.dishtodelivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DishToDeliveryDtoBase {
    private int id;
    private int quantity;
}

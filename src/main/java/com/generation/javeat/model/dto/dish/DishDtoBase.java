package com.generation.javeat.model.dto.dish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class DishDtoBase {
    private int id;
    private String name;
    private String category;
    private double price;
}

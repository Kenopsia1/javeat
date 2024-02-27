package com.generation.javeat.model.dto.menu;
import java.util.Set;

import com.generation.javeat.model.entities.Dish;
import com.generation.javeat.model.entities.Restaurant;

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
public class MenuDToWFull extends MenuDtoBase{
    private Set<Dish> dishes;
    private Restaurant restaurant;
}

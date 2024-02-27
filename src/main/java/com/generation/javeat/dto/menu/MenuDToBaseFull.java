package com.generation.javeat.dto.menu;
import java.util.Set;

import com.generation.javeat.entities.Dish;
import com.generation.javeat.entities.Restaurant;

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
public class MenuDToBaseFull extends MenuDtoBase{
    private Set<Dish> dishes;
    private Restaurant restaurant;
}

package com.generation.javeat.model.dto.dish;
import java.util.List;
import java.util.Set;

import com.generation.javeat.model.entities.DishToDelivery;
import com.generation.javeat.model.entities.Menu;

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
public class DishDtoWFull extends DishDtoBase{
    private Set<DishToDelivery> deliveries;
    private List<String> ingredients;
    private Menu menu;
}

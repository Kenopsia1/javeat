package com.generation.javeat.dto.restaurant;

import java.util.List;
import java.util.Set;

import com.generation.javeat.entities.Delivery;
import com.generation.javeat.entities.Menu;

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
public class RestaurantDtoWFull extends RestaurantDtoBase{

    private List<String> foodTypes;
    private Set<Delivery> deliveries;
    private Menu menu;
}

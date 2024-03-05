package com.generation.javeat.model.dto.restaurant;

import java.util.List;
import java.util.Set;

import com.generation.javeat.model.entities.Delivery;
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
public class RestaurantDtoWDist extends RestaurantDtoBase{
    private List<String> foodTypes;
    private Set<Delivery> deliveries;
    private Menu menu;
    private boolean isOpen;
    private int distance;
}
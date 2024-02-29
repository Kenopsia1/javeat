package com.generation.javeat.model.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class RestaurantDtoBase {
    private Integer id;
    private String phone, imgUrl, name;
    private int openingHour, closingHour, positionX, positionY, maxDeliveryDistance;
    private Double deliveryPricePerUnit;
}

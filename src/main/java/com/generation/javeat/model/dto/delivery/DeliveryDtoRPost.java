package com.generation.javeat.model.dto.delivery;

import java.time.LocalTime;
import java.util.Map;

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
public class DeliveryDtoRPost extends DeliveryDtoBase {
    private Integer user_id;
    private Integer restaurant_id;
    private LocalTime deliveryTime;
    private Map<Integer, Integer> idPlateQuantity;
}

package com.generation.javeat.model.dto.delivery;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class DeliveryDtoBase {
    private Integer id;
    private LocalDateTime expected_arrival;
    private int distance;
    private String paymentMethod, notes;
}

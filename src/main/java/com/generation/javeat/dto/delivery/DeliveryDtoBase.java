package com.generation.javeat.dto.delivery;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DeliveryDtoBase {

    private Integer id;
    private Date expected_arrival;
    private int distance;
    private String paymentMethod, notes;
}

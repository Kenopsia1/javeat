package com.generation.javeat.dto.delivery;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class DeliveryDtoR extends DeliveryDtoBase{

    public DeliveryDtoR(){};
}

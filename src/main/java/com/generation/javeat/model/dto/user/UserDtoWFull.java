package com.generation.javeat.model.dto.user;

import java.util.Set;

import com.generation.javeat.model.entities.Delivery;

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
public class UserDtoWFull extends UserDtoBase{
    private Integer id;
    private Set<Delivery> deliveries;
}

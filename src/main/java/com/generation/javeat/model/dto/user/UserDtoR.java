package com.generation.javeat.model.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class UserDtoR extends UserDtoBase{

    public UserDtoR(){};
}

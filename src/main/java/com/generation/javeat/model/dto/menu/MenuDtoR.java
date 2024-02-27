package com.generation.javeat.model.dto.menu;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class MenuDtoR extends MenuDtoBase{
    public MenuDtoR(){};
}

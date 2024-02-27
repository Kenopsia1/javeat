package com.generation.javeat.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDtoBase {

    private Integer id;
    private String mail, password, phone;
    private int positionX, positionY;

}

package com.soyukkahve.myhotel.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty(message = "This place can not be empty.")
    private String username;
    @NotEmpty(message = "This place can not be empty.")
    private String password;

    @NotNull(message = "This place is can not be null.")
    private RoleDto role;


}

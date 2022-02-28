package com.soyukkahve.myhotel.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
public class RoleDto {

    private Long id;

    @NotEmpty(message = "This place can not be empty.")
    private String name;


}

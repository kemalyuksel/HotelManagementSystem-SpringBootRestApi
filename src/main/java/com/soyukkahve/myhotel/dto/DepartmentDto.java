package com.soyukkahve.myhotel.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DepartmentDto {

    private Long id;

    @NotEmpty(message = "This place can not be empty.")
    private String name;

}

package com.soyukkahve.myhotel.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeDto {

    private Long id;

    @NotEmpty(message = "This place can not be empty.")
    private String name;

    @NotEmpty(message = "This place can not be empty.")
    private String surname;

    @NotEmpty(message = "This place can not be empty.")
    private String phoneNumber;

    @NotEmpty(message = "This place can not be empty.")
    @Email(message = "This place is not valid email format.")
    private String email;

    @NotEmpty(message = "This place can not be empty.")
    @Min(value = 0, message = "This place can not be less than 0.")
    private double salary;

    @NotNull(message = "This place is can not be null.")
    private DepartmentDto department;

    @NotNull(message = "This place is can not be null.")
    private UserDto user;

}

package com.soyukkahve.myhotel.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class RoomDto {

    private Long id;

    @NotEmpty(message = "This place can not be empty.")
    private String description;

    @NotEmpty(message = "This place can not be empty.")
    private String roomType;

    @NotEmpty(message = "This place can not be empty.")
    private String maintenance;

    private boolean enabled = false;

    @Min(value = 0, message = "This place can not be less than 0.")
    @NotNull(message = "This place is can not be null.")
    private double price;

    @Min(value = 0, message = "This place can not be less than 0.")
    @NotNull(message = "This place is can not be null.")
    private int bedAmount;

}

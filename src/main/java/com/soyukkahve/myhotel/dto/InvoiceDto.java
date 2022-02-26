package com.soyukkahve.myhotel.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
public class InvoiceDto {

    private Long id;

    @NotNull(message = "This place is can not be null.")
    private Date billingDate;

    @Min(value = 0, message = "This place can not be less than 0.")
    private double price;

    @NotNull(message = "This place is can not be null.")
    private GuestDto guest;

}

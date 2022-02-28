package com.soyukkahve.myhotel.controller.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CreateReservationRequest {

    @NotNull(message = "This field cannot be null.")
    private Long guestId;
    @NotNull(message = "This field cannot be null.")
    private Long roomId;
    @NotNull(message = "This field cannot be null.")
    private Date releaseDate;

}

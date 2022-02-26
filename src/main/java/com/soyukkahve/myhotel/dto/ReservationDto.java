package com.soyukkahve.myhotel.dto;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
public class ReservationDto {

    private Long id;

    @NotNull(message = "This place is can not be null.")
    private Date entryDate;

    @NotNull(message = "This place is can not be null.")
    private Date releaseDate;

    @NotNull(message = "This place is can not be null.")
    private GuestDto guest;

    @NotNull(message = "This place is can not be null.")
    private RoomDto room;

}

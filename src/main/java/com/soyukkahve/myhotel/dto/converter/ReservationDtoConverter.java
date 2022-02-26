package com.soyukkahve.myhotel.dto.converter;

import com.soyukkahve.myhotel.dto.ReservationDto;
import com.soyukkahve.myhotel.model.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReservationDtoConverter {

    private final ModelMapper modelMapper;

    public ReservationDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ReservationDto convertToDto(Reservation reservation) {
        ReservationDto reservationDto = modelMapper.map(reservation, ReservationDto.class);

        return reservationDto;
    }

    public Reservation convertToEntity(ReservationDto reservationDto) {
        Reservation reservation = modelMapper.map(reservationDto, Reservation.class);

//        if (userDto.getId() != null) {
//
//        }
        return reservation;
    }


}

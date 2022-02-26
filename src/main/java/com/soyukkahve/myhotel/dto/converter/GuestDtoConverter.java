package com.soyukkahve.myhotel.dto.converter;

import com.soyukkahve.myhotel.dto.GuestDto;
import com.soyukkahve.myhotel.model.Guest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GuestDtoConverter {

    private final ModelMapper modelMapper;

    public GuestDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GuestDto convertToDto(Guest guest) {
        GuestDto guestDto = modelMapper.map(guest, GuestDto.class);

        return guestDto;
    }

    public Guest convertToEntity(GuestDto guestDto) {
        Guest guest = modelMapper.map(guestDto, Guest.class);

//        if (userDto.getId() != null) {
//
//        }
        return guest;
    }

}

package com.soyukkahve.myhotel.dto.converter;

import com.soyukkahve.myhotel.dto.RoomDto;
import com.soyukkahve.myhotel.model.Reservation;
import com.soyukkahve.myhotel.model.Room;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoomDtoConverter {

    private final ModelMapper modelMapper;

    public RoomDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RoomDto convertToDto(Room room) {
        RoomDto roomDto = modelMapper.map(room, RoomDto.class);

        return roomDto;
    }

    public Room convertToEntity(RoomDto roomDto) {
        Room room = modelMapper.map(roomDto, Room.class);
//        if (userDto.getId() != null) {
//
//        }
        return room;
    }


}

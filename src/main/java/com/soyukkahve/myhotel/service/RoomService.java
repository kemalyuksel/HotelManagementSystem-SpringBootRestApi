package com.soyukkahve.myhotel.service;

import com.soyukkahve.myhotel.dto.RoomDto;
import com.soyukkahve.myhotel.dto.converter.RoomDtoConverter;
import com.soyukkahve.myhotel.exception.NotFoundException;
import com.soyukkahve.myhotel.exception.RoomIsNotEnabledException;
import com.soyukkahve.myhotel.model.Room;
import com.soyukkahve.myhotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomDtoConverter roomDtoConverter;


    public RoomService(RoomRepository roomRepository, RoomDtoConverter roomDtoConverter) {
        this.roomRepository = roomRepository;
        this.roomDtoConverter = roomDtoConverter;
    }

    public Room getEnableRoomById(Long id){
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomIsNotEnabledException("Room is full, Room id : " + id));
    }


    public RoomDto getById(Long id){
        return roomDtoConverter.convertToDto(findById(id));
    }

    public Room findById(Long id){
        return roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Room could not find by id : " + id ));
    }


    public List<RoomDto> getAll(){

        List<Room> rooms = roomRepository.findAll();
        List<RoomDto> roomDtos = rooms.
                stream()
                .map(r -> roomDtoConverter.convertToDto(r))
                .collect(Collectors.toList());

        return roomDtos;
    }

    public RoomDto save(RoomDto roomDto){

        Room room = roomDtoConverter.convertToEntity(roomDto);
        room.setEnabled(true);

        return roomDtoConverter.convertToDto(roomRepository.save(room));
    }

    public RoomDto updateRoomById(Long id,RoomDto roomDto){

        RoomDto updatedRoom = getById(id);

        updatedRoom.setMaintenance(roomDto.getMaintenance());
        updatedRoom.setEnabled(roomDto.isEnabled());
        updatedRoom.setPrice(roomDto.getPrice());
        updatedRoom.setDescription(roomDto.getDescription());
        updatedRoom.setRoomType(roomDto.getRoomType());
        updatedRoom.setBedAmount(roomDto.getBedAmount());

        Room room = roomDtoConverter.convertToEntity(updatedRoom);

        return roomDtoConverter.convertToDto(roomRepository.save(room));
    }



}

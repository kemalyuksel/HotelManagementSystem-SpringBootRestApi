package com.soyukkahve.myhotel.controller;

import com.soyukkahve.myhotel.dto.RoomDto;
import com.soyukkahve.myhotel.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/rooms/")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAll(){
        return ResponseEntity.ok(roomService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long id){
        return ResponseEntity.ok(roomService.getById(id));
    }

    @PostMapping
    public ResponseEntity<RoomDto> createRoom(@Valid @RequestBody RoomDto roomDto){
        return ResponseEntity.ok(roomService.save(roomDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<RoomDto> updateRoomById(@PathVariable Long id, @Valid @RequestBody RoomDto roomDto){
        return ResponseEntity.ok(roomService.updateRoomById(id,roomDto));
    }


}

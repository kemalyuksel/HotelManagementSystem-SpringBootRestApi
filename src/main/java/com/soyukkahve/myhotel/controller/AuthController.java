package com.soyukkahve.myhotel.controller;

import com.soyukkahve.myhotel.dto.GuestDto;
import com.soyukkahve.myhotel.controller.request.GuestRegisterRequest;
import com.soyukkahve.myhotel.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/v1/auth/")
public class AuthController {

    private final GuestService guestService;

    public AuthController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("register")
    public ResponseEntity<GuestDto> createUser(@Valid @RequestBody GuestRegisterRequest guestRegisterDto){

        GuestDto guestDto = guestService.save(guestRegisterDto);

        return ResponseEntity.ok(guestDto);
    }

}

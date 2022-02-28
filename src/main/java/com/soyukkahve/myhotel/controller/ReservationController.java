package com.soyukkahve.myhotel.controller;

import com.soyukkahve.myhotel.controller.request.CreateReservationRequest;
import com.soyukkahve.myhotel.dto.ReservationDto;
import com.soyukkahve.myhotel.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/reservations/")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAll(){
        return ResponseEntity.ok(reservationService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ReservationDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ReservationDto> create(@Valid @RequestBody CreateReservationRequest request){
        return ResponseEntity.ok(reservationService.createReservation(request));
    }




}

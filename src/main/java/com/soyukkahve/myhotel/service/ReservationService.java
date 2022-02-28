package com.soyukkahve.myhotel.service;

import com.soyukkahve.myhotel.controller.request.CreateReservationRequest;
import com.soyukkahve.myhotel.dto.*;
import com.soyukkahve.myhotel.dto.converter.GuestDtoConverter;
import com.soyukkahve.myhotel.dto.converter.InvoiceDtoConverter;
import com.soyukkahve.myhotel.dto.converter.ReservationDtoConverter;
import com.soyukkahve.myhotel.exception.NotFoundException;
import com.soyukkahve.myhotel.model.Guest;
import com.soyukkahve.myhotel.model.Invoice;
import com.soyukkahve.myhotel.model.Reservation;
import com.soyukkahve.myhotel.model.Room;
import com.soyukkahve.myhotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final GuestService guestService;
    private final RoomService roomService;
    private final InvoiceService invoiceService;
    private final InvoiceDtoConverter invoiceDtoConverter;
    private final ReservationDtoConverter reservationDtoConverter;
    private final GuestDtoConverter guestDtoConverter;

    public ReservationService(ReservationRepository reservationRepository, GuestService guestService, RoomService roomService, InvoiceService invoiceService, InvoiceDtoConverter invoiceDtoConverter, ReservationDtoConverter reservationDtoConverter, GuestDtoConverter guestDtoConverter) {
        this.reservationRepository = reservationRepository;
        this.guestService = guestService;
        this.roomService = roomService;
        this.invoiceService = invoiceService;
        this.invoiceDtoConverter = invoiceDtoConverter;
        this.reservationDtoConverter = reservationDtoConverter;
        this.guestDtoConverter = guestDtoConverter;
    }

    public Reservation findById(Long id){
        return reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reservation could not find by id : " + id ));
    }

    public ReservationDto getById(Long id){
        return reservationDtoConverter.convertToDto(findById(id));
    }


    public List<ReservationDto> getAll(){

        List<Reservation> reservations = reservationRepository.findAll();

        List<ReservationDto> reservationDtoList = reservations
                .stream()
                .map(r -> reservationDtoConverter.convertToDto(r))
                .collect(Collectors.toList());

        return reservationDtoList;
    }



    public ReservationDto createReservation(CreateReservationRequest request) {

        Guest guest = guestService.findById(request.getGuestId());

        Room room = roomService.getEnableRoomById(request.getRoomId());
        room.setEnabled(false);

        // Calculating billing price ((releaseDate - entryDate) * roomPrice) . | roomPrice = DailyPrice
        long diffInMillis = Math.abs(request.getReleaseDate().getTime() - new Date().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        Invoice invoice = Invoice.builder()
                .billingDate(new Date())
                .price(diff*room.getPrice())
                .guest(guest)
                .build();

//                BUILDER DESIGN PATTERN
//                new Invoice(
//                new Date(),
//                (diff*room.getPrice()),
//                guest);

        invoiceService.save(invoiceDtoConverter.convertToDto(invoice));


        Reservation  reservation = Reservation.builder()
                .entryDate(new Date())
                .releaseDate(request.getReleaseDate())
                .guest(guest)
                .room(room)
                .build();

//                BUILDER DESIGN PATTERN
//                new Reservation(new Date(),
//                request.getReleaseDate(),
//                guest,
//                room);


        return reservationDtoConverter.convertToDto(reservationRepository.save(reservation));
    }


}

package com.soyukkahve.myhotel.service;

import com.soyukkahve.myhotel.controller.request.GuestRegisterRequest;
import com.soyukkahve.myhotel.dto.*;
import com.soyukkahve.myhotel.dto.converter.GuestDtoConverter;
import com.soyukkahve.myhotel.exception.NotFoundException;
import com.soyukkahve.myhotel.model.Guest;
import com.soyukkahve.myhotel.model.Role;
import com.soyukkahve.myhotel.model.User;
import com.soyukkahve.myhotel.repository.GuestRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {

    private final GuestRepository guestRepository;
    private final RoleService roleService;
    private final GuestDtoConverter guestDtoConverter;
    private final BCryptPasswordEncoder encoder;

    public GuestService(GuestRepository guestRepository,
                        RoleService roleService,
                        GuestDtoConverter guestDtoConverter,
                        BCryptPasswordEncoder encoder) {

        this.guestRepository = guestRepository;
        this.roleService = roleService;
        this.guestDtoConverter = guestDtoConverter;
        this.encoder = encoder;
    }

    public List<GuestDto> getAll(){

        List<Guest> guests = guestRepository.findAll();

        List<GuestDto> guestDtoList = guests.stream()
                .map(guest -> guestDtoConverter.convertToDto(guest))
                .collect(Collectors.toList());

        return guestDtoList;
    }

    public GuestDto getById(Long id){
        return guestDtoConverter.convertToDto(findById(id));
    }

    public Guest findById(Long id){
        return guestRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Guest could not find by id : " + id));
    }


    public GuestDto save(GuestRegisterRequest dto){

        //Find available Role for Guest
        Role role = roleService.findRoleByName("GUEST");

        //Creating User for Guest
        User user = User.builder()
                .username(dto.getUsername())
                .password(encoder.encode(dto.getPassword()))
                .role(role)
                .build();

//        user.setPassword(encoder.encode(dto.getPassword()));
//
////                new User(dto.getUsername(),dto.getPassword(),role);


        //Creating Guest
        Guest guest = Guest.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .user(user)
                .build();


//                new Guest(dto.getName(),dto.getSurname(),dto.getPhoneNumber(),dto.getEmail(),user);

        return guestDtoConverter.convertToDto(guestRepository.save(guest));
    }




}

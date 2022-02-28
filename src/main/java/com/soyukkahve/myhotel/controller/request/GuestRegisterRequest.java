package com.soyukkahve.myhotel.controller.request;


import lombok.Data;

@Data
public class GuestRegisterRequest {

    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;



}

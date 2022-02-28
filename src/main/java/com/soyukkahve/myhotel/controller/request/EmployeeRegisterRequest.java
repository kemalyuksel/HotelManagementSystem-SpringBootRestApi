package com.soyukkahve.myhotel.controller.request;

import lombok.Data;

@Data
public class EmployeeRegisterRequest {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private double salary;

}

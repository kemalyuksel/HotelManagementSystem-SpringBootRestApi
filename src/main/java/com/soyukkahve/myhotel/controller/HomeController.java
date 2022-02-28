package com.soyukkahve.myhotel.controller;

import com.soyukkahve.myhotel.dto.EmployeeDto;
import com.soyukkahve.myhotel.controller.request.EmployeeRegisterRequest;
import com.soyukkahve.myhotel.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/home")
public class HomeController {

    private final EmployeeService employeeService;


    public HomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @RequestMapping("/")
//    public String index() {
//        return "Welcome to SoyukKayfe Hotel";
//    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }





}

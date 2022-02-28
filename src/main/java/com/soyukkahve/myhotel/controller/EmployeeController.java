package com.soyukkahve.myhotel.controller;


import com.soyukkahve.myhotel.controller.request.EmployeeRegisterRequest;
import com.soyukkahve.myhotel.dto.EmployeeDto;

import com.soyukkahve.myhotel.model.Employee;
import com.soyukkahve.myhotel.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/employees/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@Valid @RequestBody EmployeeRegisterRequest request){

        EmployeeDto employeeDto = employeeService.save(request);

        return ResponseEntity.ok(employeeDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> update(@Valid @RequestBody EmployeeRegisterRequest request,@PathVariable Long id){

        return ResponseEntity.ok(employeeService.update(id,request));
    }



}

package com.soyukkahve.myhotel.controller;

import com.soyukkahve.myhotel.dto.DepartmentDto;
import com.soyukkahve.myhotel.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/departments/")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAll(){
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getById(id));
    }


    @PostMapping
    public ResponseEntity<DepartmentDto> create(@Valid @RequestBody DepartmentDto request){

        return  ResponseEntity.ok(departmentService.save(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> update(@Valid @RequestBody DepartmentDto request,@PathVariable Long id){

        return ResponseEntity.ok(departmentService.update(id,request));
    }

}

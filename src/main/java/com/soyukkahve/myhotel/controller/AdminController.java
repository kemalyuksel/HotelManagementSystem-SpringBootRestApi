package com.soyukkahve.myhotel.controller;

import com.soyukkahve.myhotel.controller.request.AddDepartmentToEmployeeRequest;
import com.soyukkahve.myhotel.dto.DepartmentDto;
import com.soyukkahve.myhotel.dto.RoleDto;
import com.soyukkahve.myhotel.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin/")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("addDepartmentToEmployee")
    public String addDepartmentToEmployee(@RequestBody AddDepartmentToEmployeeRequest request){

        adminService.addDepartmentToEmployee(request);

        return "Added";
    }

    @PostMapping("addRole")
    public String addRole(@RequestBody RoleDto request){

        adminService.addRole(request);

        return "Added";
    }






}

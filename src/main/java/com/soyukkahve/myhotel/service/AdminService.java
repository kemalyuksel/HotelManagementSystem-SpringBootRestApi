package com.soyukkahve.myhotel.service;

import com.soyukkahve.myhotel.controller.request.AddDepartmentToEmployeeRequest;
import com.soyukkahve.myhotel.dto.*;
import com.soyukkahve.myhotel.dto.converter.DepartmentDtoConverter;
import com.soyukkahve.myhotel.dto.converter.EmployeeDtoConverter;
import com.soyukkahve.myhotel.dto.converter.RoleDtoConverter;
import com.soyukkahve.myhotel.model.Department;
import com.soyukkahve.myhotel.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final EmployeeService employeeService;
    private final EmployeeDtoConverter employeeDtoConverter;
    private final DepartmentService departmentService;
    private final DepartmentDtoConverter departmentDtoConverter;
    private final RoleService roleService;
    private final RoleDtoConverter roleDtoConverter;


    public AdminService(EmployeeService employeeService,
                        EmployeeDtoConverter employeeDtoConverter,
                        DepartmentService departmentService,
                        DepartmentDtoConverter departmentDtoConverter,
                        RoleService roleService,
                        RoleDtoConverter roleDtoConverter) {

        this.employeeService = employeeService;
        this.employeeDtoConverter = employeeDtoConverter;
        this.departmentService = departmentService;
        this.departmentDtoConverter = departmentDtoConverter;
        this.roleService = roleService;
        this.roleDtoConverter = roleDtoConverter;
    }

    public void addDepartmentToEmployee(AddDepartmentToEmployeeRequest dto){

        Department department = departmentDtoConverter.convertToEntity(departmentService.getById(dto.getDepartmentId()));
        Employee employee = employeeDtoConverter.convertToEntity(employeeService.getById(dto.getEmployeeId()));

        employee.setDepartment(department);

        employeeService.saveAndUpdate(employee);
    }

    public void addDepartment(DepartmentDto departmentDto){
        departmentService.save(departmentDto);
    }

    public void addRole(RoleDto roleDto){
        roleService.save(roleDto);
    }

}

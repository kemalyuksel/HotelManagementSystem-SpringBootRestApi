package com.soyukkahve.myhotel.dto.converter;

import com.soyukkahve.myhotel.dto.EmployeeDto;
import com.soyukkahve.myhotel.model.Employee;
import com.soyukkahve.myhotel.model.Guest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoConverter {

    private final ModelMapper modelMapper;

    public EmployeeDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        return employeeDto;
    }

    public Employee convertToEntity(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);

//        if (userDto.getId() != null) {
//
//        }
        return employee;
    }

}

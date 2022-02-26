package com.soyukkahve.myhotel.dto.converter;

import com.soyukkahve.myhotel.dto.DepartmentDto;
import com.soyukkahve.myhotel.model.Department;
import com.soyukkahve.myhotel.model.Guest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDtoConverter {

    private final ModelMapper modelMapper;

    public DepartmentDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DepartmentDto convertToDto(Department department) {
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

        return departmentDto;
    }

    public Department convertToEntity(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);

//        if (userDto.getId() != null) {
//
//        }
        return department;
    }

}

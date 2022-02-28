package com.soyukkahve.myhotel.service;

import com.soyukkahve.myhotel.dto.DepartmentDto;
import com.soyukkahve.myhotel.dto.RoomDto;
import com.soyukkahve.myhotel.dto.converter.DepartmentDtoConverter;
import com.soyukkahve.myhotel.exception.NotFoundException;
import com.soyukkahve.myhotel.model.Department;
import com.soyukkahve.myhotel.model.Room;
import com.soyukkahve.myhotel.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentDtoConverter departmentDtoConverter;

    public DepartmentService(DepartmentRepository departmentRepository,
                             DepartmentDtoConverter departmentDtoConverter) {

        this.departmentRepository = departmentRepository;
        this.departmentDtoConverter = departmentDtoConverter;
    }

    public List<DepartmentDto> getAll(){

        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDto> departmentDtoList =
                departments.stream()
                .map(department -> departmentDtoConverter.convertToDto(department))
                .collect(Collectors.toList());

        return departmentDtoList;
    }

    public Department findById(Long id){
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Department could not find by id : " + id ));
    }

    public DepartmentDto getById(Long id){
        return departmentDtoConverter.convertToDto(findById(id));
    }

    public DepartmentDto save(DepartmentDto departmentDto){

        Department department = departmentDtoConverter.convertToEntity(departmentDto);

        return departmentDtoConverter.convertToDto(departmentRepository.save(department));
    }

    public DepartmentDto update(Long id,DepartmentDto departmentDto){

        DepartmentDto updatedDepartment = getById(id);

        updatedDepartment.setName(departmentDto.getName());

        return save(updatedDepartment);
    }


}

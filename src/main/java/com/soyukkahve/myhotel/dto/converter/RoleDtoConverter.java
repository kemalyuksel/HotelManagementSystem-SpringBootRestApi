package com.soyukkahve.myhotel.dto.converter;

import com.soyukkahve.myhotel.dto.RoleDto;
import com.soyukkahve.myhotel.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleDtoConverter {

    private final ModelMapper modelMapper;

    public RoleDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RoleDto convertToDto(Role role) {
        RoleDto roleDto = modelMapper.map(role, RoleDto.class);

        return roleDto;
    }

    public Role convertToEntity(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);

//        if (userDto.getId() != null) {
//
//        }
        return role;
    }

}

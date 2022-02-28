package com.soyukkahve.myhotel.service;

import com.soyukkahve.myhotel.dto.RoleDto;
import com.soyukkahve.myhotel.dto.converter.RoleDtoConverter;
import com.soyukkahve.myhotel.exception.NotFoundException;
import com.soyukkahve.myhotel.model.Role;
import com.soyukkahve.myhotel.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleDtoConverter roleDtoConverter;

    public RoleService(RoleRepository roleRepository, RoleDtoConverter roleDtoConverter) {
        this.roleRepository = roleRepository;
        this.roleDtoConverter = roleDtoConverter;
    }

    public List<RoleDto> getAll(){

        List<Role> roles = roleRepository.findAll();
        List<RoleDto> roleDtoList = roles.stream().map(role -> roleDtoConverter.convertToDto(role)).collect(Collectors.toList());

        return roleDtoList;
    }

    public Role findById(Long id){
        return roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role could not find by id : " + id ));
    }

    public RoleDto getById(Long id){
        return roleDtoConverter.convertToDto(findById(id));
    }


    public RoleDto save(RoleDto roleDto){

        Role role = roleDtoConverter.convertToEntity(roleDto);

        return roleDtoConverter.convertToDto(roleRepository.save(role));

    }

    public Role findRoleByName(String role){
        return roleRepository.getRoleByName(role);
    }

}

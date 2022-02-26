package com.soyukkahve.myhotel.dto.converter;

import com.soyukkahve.myhotel.dto.UserDto;
import com.soyukkahve.myhotel.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    private final ModelMapper modelMapper;

    public UserDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }

    public User convertToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

//        if (userDto.getId() != null) {
//
//        }
        return user;
    }

}

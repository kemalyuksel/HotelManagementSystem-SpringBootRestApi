package com.soyukkahve.myhotel.service;

import com.soyukkahve.myhotel.dto.UserDto;
import com.soyukkahve.myhotel.dto.converter.UserDtoConverter;
import com.soyukkahve.myhotel.exception.NotFoundException;
import com.soyukkahve.myhotel.model.User;
import com.soyukkahve.myhotel.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;


    public UserService(UserRepository userRepository,
                       UserDtoConverter userDtoConverter) {

        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAll(){

        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = users.stream().map(user -> userDtoConverter.convertToDto(user)).collect(Collectors.toList());

        return userDtoList;
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User could not find by id : " + id ));
    }

    public UserDto getById(Long id){
        return userDtoConverter.convertToDto(findById(id));
    }


    public User getByUsername(String username){

        return userRepository.getUserByUsername(username);
    }




}

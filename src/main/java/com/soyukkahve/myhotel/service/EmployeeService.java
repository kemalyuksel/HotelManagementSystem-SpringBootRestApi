package com.soyukkahve.myhotel.service;

import com.soyukkahve.myhotel.controller.request.EmployeeRegisterRequest;
import com.soyukkahve.myhotel.dto.*;
import com.soyukkahve.myhotel.dto.converter.EmployeeDtoConverter;
import com.soyukkahve.myhotel.exception.NotFoundException;
import com.soyukkahve.myhotel.model.*;
import com.soyukkahve.myhotel.repository.EmployeeRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDtoConverter employeeDtoConverter;
    private final UserService userService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder encoder;

    public EmployeeService(EmployeeRepository employeeRepository,
                           EmployeeDtoConverter employeeDtoConverter,
                           RoleService roleService,
                           UserService userService,
                           BCryptPasswordEncoder encoder) {

        this.employeeRepository = employeeRepository;
        this.employeeDtoConverter = employeeDtoConverter;
        this.roleService = roleService;
        this.userService = userService;
        this.encoder = encoder;
    }

    public List<EmployeeDto> getAll(){

        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees
                .stream()
                .map(employee -> employeeDtoConverter.convertToDto(employee))
                .collect(Collectors.toList());

        return employeeDtos;
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee could not find by id : " + id ));
    }

    public EmployeeDto getById(Long id){
        return employeeDtoConverter.convertToDto(findById(id));
    }


    public EmployeeDto save(EmployeeRegisterRequest dto){

        //Find available Role for Employee
        Role role = roleService.findRoleByName("EMPLOYEE");

        //Creating User for Employee
        User user = User.builder()
                .username(dto.getUsername())
                .password(encoder.encode(dto.getPassword()))
                .role(role)
                .build();

//                new User(dto.getUsername(),dto.getPassword(),role);
//        user.setPassword(encoder.encode(dto.getPassword()));

        //Creating Employee
        Employee employee = Employee.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .salary(dto.getSalary())
                .user(user)
                .build();

//                new Employee(dto.getName(),dto.getSurname(),dto.getPhoneNumber(),dto.getEmail(),dto.getSalary(),user);

        return employeeDtoConverter.convertToDto(employeeRepository.save(employee));
    }

    public EmployeeDto update(Long id,EmployeeRegisterRequest request){

        // Finding Employee's User
        User user = userService.getByUsername(request.getUsername());
            user.setPassword(encoder.encode(request.getPassword()));

        // Finding Employee and update

        Employee employee = findById(id);
            employee.setUser(user);
            employee.setSalary(request.getSalary());
            employee.setEmail(request.getEmail());
            employee.setName(request.getName());
            employee.setPhoneNumber(request.getPhoneNumber());
            employee.setSurname(request.getSurname());

        saveAndUpdate(employee);

        return employeeDtoConverter.convertToDto(employee);
    }

    public void saveAndUpdate(Employee employee){
        employeeRepository.save(employee);
    }



}

package com.soyukkahve.myhotel.controller.request;

import lombok.Data;

@Data
public class AddDepartmentToEmployeeRequest {

    private Long departmentId;
    private Long employeeId;

}

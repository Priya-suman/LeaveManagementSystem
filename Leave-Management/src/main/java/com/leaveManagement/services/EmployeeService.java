package com.leaveManagement.services;

import com.leaveManagement.dto.request.CreateEmployeeRequest;
import com.leaveManagement.dto.response.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse createEmployee(CreateEmployeeRequest request);
}

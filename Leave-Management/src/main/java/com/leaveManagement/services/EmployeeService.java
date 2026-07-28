package com.leaveManagement.services;

import com.leaveManagement.dto.request.CreateEmployeeRequest;
import com.leaveManagement.dto.request.UpdateEmployeeRequest;
import com.leaveManagement.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(CreateEmployeeRequest request);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(int id);

    EmployeeResponse getByEmployeeCode(String employeeCode);

    EmployeeResponse updateEmployee(UpdateEmployeeRequest request);

    void deleteEmployee(String employeeCode);
}

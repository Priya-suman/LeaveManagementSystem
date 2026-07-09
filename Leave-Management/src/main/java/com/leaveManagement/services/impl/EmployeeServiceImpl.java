package com.leaveManagement.services.impl;

import com.leaveManagement.dto.request.CreateEmployeeRequest;
import com.leaveManagement.dto.response.EmployeeResponse;
import com.leaveManagement.entity.Employee;
import com.leaveManagement.enums.EmployeeStatus;
import com.leaveManagement.repository.EmployeeRepository;
import com.leaveManagement.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse createEmployee(CreateEmployeeRequest request) {
        /*validate request
        * check if employee already exists
        * check unique email
        * check unique phone number
        * build Employee from CreateEmployeeRequest
        * save Employee
        * build EmployeeResponse from Employee
        * return EmployeeResponse*/

        valudateEmployee(request);
        Employee employee = buildEmployee(request);
        employeeRepository.save(employee);
        return buildEmployeeResponse(employee);
    }

    private void valudateEmployee(CreateEmployeeRequest request) {
        if(employeeRepository.existsByEmployeeCode(request.getEmployeeCode())){
            throw new RuntimeException("Employee already exists with employee code:" + request.getEmployeeCode());
        }
        if(employeeRepository.existsByOfficialEmail(request.getOfficial_email())){
            throw new RuntimeException("Employee already exists with email:" + request.getOfficial_email());
        }
        if(employeeRepository.existsByPhone(request.getPhone())){
            throw new RuntimeException("Employee already exists with phone:" + request.getPhone());
        }
    }

    private EmployeeResponse buildEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .employeeCode(employee.getEmployeeCode())
                .name(employee.getName())
                .DoJ(employee.getDoJ())
                .address(employee.getAddress())
                .DoC(employee.getDoC())
                .gender(employee.getGender())
                .official_email(employee.getOfficialEmail())
                .phone(employee.getPhone())
                .DoB(employee.getDoB())
                .status(employee.getStatus())
                .Probation_period(employee.getProbationPeriod())
                .build();
    }

    private Employee buildEmployee(CreateEmployeeRequest request) {
        LocalDate DoC = request.getDoJ().plusMonths(request.getProbation_period());
        return Employee.builder()
                        .employeeCode(request.getEmployeeCode())
                        .name(request.getName())
                        .status(EmployeeStatus.ACTIVE)
                        .gender(request.getGender())
                        .doJ(request.getDoJ())
                        .probationPeriod(request.getProbation_period())
                        .officialEmail(request.getOfficial_email())
                        .phone(request.getPhone())
                        .DoB(request.getDoB())
                        .address(request.getAddress())
                        .build();
    }

}

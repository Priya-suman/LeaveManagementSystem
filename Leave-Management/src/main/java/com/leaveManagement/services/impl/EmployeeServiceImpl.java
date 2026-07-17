package com.leaveManagement.services.impl;

import com.leaveManagement.dto.request.CreateEmployeeRequest;
import com.leaveManagement.dto.response.EmployeeResponse;
import com.leaveManagement.entity.Employee;
import com.leaveManagement.enums.EmployeeStatus;
import com.leaveManagement.exceptions.DuplicateEmailException;
import com.leaveManagement.exceptions.DuplicatePhoneNumberException;
import com.leaveManagement.exceptions.EmployeeAlreadyExistsException;
import com.leaveManagement.exceptions.EmployeeNotFoundException;
import com.leaveManagement.repository.EmployeeRepository;
import com.leaveManagement.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        * calculate confirmation date
        * save Employee
        * build EmployeeResponse from Employee
        * return EmployeeResponse*/

        valudateEmployee(request);
        Employee employee = buildEmployee(request);
        employee.setDoC(employee.getDoJ().plusMonths(request.getProbation_period()));
        employeeRepository.save(employee);
        return buildEmployeeResponse(employee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream().map(this::buildEmployeeResponse).toList();
    }

    @Override
    public EmployeeResponse getEmployeeById(int id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id:" + id));
        return buildEmployeeResponse(employee);
    }


    @Override
    public EmployeeResponse getByEmployeeCode(String employeeCode) {
        Optional<Employee> byEmployeeCode = employeeRepository.findByEmployeeCode(employeeCode);
        if(byEmployeeCode.isEmpty()){
            throw new EmployeeNotFoundException("Employee not found with employee code:" + employeeCode);
        }
        return buildEmployeeResponse(byEmployeeCode.get());
    }

    private void valudateEmployee(CreateEmployeeRequest request) {
        if(employeeRepository.existsByEmployeeCode(request.getEmployeeCode())){
            throw new EmployeeAlreadyExistsException("Employee already exists with employee code:" + request.getEmployeeCode());
        }
        if(employeeRepository.existsByOfficialEmail(request.getOfficial_email())){
            throw new DuplicateEmailException("Employee already exists with email:" + request.getOfficial_email());
        }
        if(employeeRepository.existsByPhone(request.getPhone())){
            throw new DuplicatePhoneNumberException("Employee already exists with phone:" + request.getPhone());
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
                        .DoB(request.getDob())
                        .address(request.getAddress())
                        .build();
    }

}

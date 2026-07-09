package com.leaveManagement.services;

import com.leaveManagement.dto.request.EmployeeRequest;
import com.leaveManagement.dto.response.EmployeeResponse;
import com.leaveManagement.entity.Employee;
import com.leaveManagement.enums.EmployeeStatus;
import com.leaveManagement.exceptions.EmployeeNotFoundException;
import com.leaveManagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServices.class);

    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> allEmployee = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponse = new ArrayList<>();
        BeanUtils.copyProperties(allEmployee, employeeResponse);
        return employeeResponse;
    }

    public EmployeeResponse getById(String idy){
        Employee employee = employeeRepository.findByEmployeeCode(idy)
                            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        EmployeeResponse response = new EmployeeResponse();
        BeanUtils.copyProperties(employee, response);
        return response;
    }

    public EmployeeResponse getByDoJ(LocalDate Doj){
        Employee employee = employeeRepository.findByDoJ(Doj).orElseThrow(() -> new EmployeeNotFoundException("Employee not found on DoJ : " + Doj));
        EmployeeResponse response = new EmployeeResponse();
        BeanUtils.copyProperties(employee, response);
        return response;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequest, employee);
        employee.setStatus(EmployeeStatus.ACTIVE);
        LocalDate dateOfConfirmation = getDateOfConfirmation(employeeRequest, employee);
        employee.setDoC(dateOfConfirmation);
        Employee newEmp = employeeRepository.save(employee);
        EmployeeResponse response = new EmployeeResponse();
        BeanUtils.copyProperties(newEmp, response);
        return response;
    }

    private static LocalDate getDateOfConfirmation(EmployeeRequest employeeRequest, Employee employee) {
        LocalDate DoC;
        if(employeeRequest.getDoC() == null){
            if(employeeRequest.getProbation_period() != null){
                return employeeRequest.getDoJ().plusDays(employeeRequest.getProbation_period());
            }else{
                return employeeRequest.getDoJ();
            }
        }else {
            return employeeRequest.getDoC();
        }
    }


}

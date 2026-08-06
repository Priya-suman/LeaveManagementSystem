package com.leaveManagement.services.impl;

import com.leaveManagement.dto.response.EmployeeDesignationResponse;
import com.leaveManagement.entity.Employee;
import com.leaveManagement.entity.EmployeeDesignation;
import com.leaveManagement.exceptions.EmployeeNotFoundException;
import com.leaveManagement.mapper.EmployeeDesignationMapper;
import com.leaveManagement.repository.EmployeeDesignationRepository;
import com.leaveManagement.repository.EmployeeRepository;
import com.leaveManagement.services.EmployeeDesignationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeDesignationServiceImpl implements EmployeeDesignationService{
    private final EmployeeDesignationMapper employeeDesignationMapper;
    private final EmployeeRepository employeeRepository;
    private final EmployeeDesignationRepository employeeDesignationRepository;

    @Override
    public List<EmployeeDesignationResponse> accessHistoryByEmpCode(String employeecode) {
        Employee employee = employeeRepository.findByEmployeeCode(employeecode).orElseThrow(() -> new EmployeeNotFoundException("Employee not found by emplpyee code :" + employeecode));
        List<EmployeeDesignation> allByEmployee = employeeDesignationRepository.findAllByEmployee(employee);

        /*convert EmployeeDesignation list to lost of EmployeeDesignationResponse...*/
        List<EmployeeDesignationResponse> collect = allByEmployee.stream().map(ed -> employeeDesignationMapper.toResponse(ed)).collect(Collectors.toList());
        return collect;
    }
}

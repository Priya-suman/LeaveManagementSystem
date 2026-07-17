package com.leaveManagement.controller;

import com.leaveManagement.dto.request.CreateEmployeeRequest;
import com.leaveManagement.dto.response.EmployeeResponse;
import com.leaveManagement.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody CreateEmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeRequest));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/{employeeCode}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable String employeeCode) {
        return ResponseEntity.ok(employeeService.getByEmployeeCode(employeeCode));
    }
}

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

    /*@GetMapping("/all")
    public List<EmployeeResponse> getAllEmployees() {
        return employeeServices.getAllEmployees();
    }
    @GetMapping("/{EmpIdy}")
    public ResponseEntity<EmployeeResponse> getById(String EmpIdy) {
        return ResponseEntity.ok(employeeServices.getById(EmpIdy));
    }

    @GetMapping("/DoJ/{Doj}")
    public ResponseEntity<EmployeeResponse> getByDoJ(@RequestParam LocalDate Doj) {
        return ResponseEntity.ok(employeeServices.getByDoJ(Doj));
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse response = employeeServices.saveEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }*/

}

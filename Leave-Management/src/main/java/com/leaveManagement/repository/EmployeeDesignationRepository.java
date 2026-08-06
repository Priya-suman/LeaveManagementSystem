package com.leaveManagement.repository;

import com.leaveManagement.entity.Employee;
import com.leaveManagement.entity.EmployeeDesignation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDesignationRepository extends JpaRepository<EmployeeDesignation, Integer> {

    List<EmployeeDesignation> findAllByEmployee(Employee employee);
}

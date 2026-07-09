package com.leaveManagement.repository;

import com.leaveManagement.entity.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    Optional<Employee> findByEmployeeCode(String Idy);

    Optional<Employee> findByDoJ(LocalDate DoJ);

    boolean existsByEmployeeCode(@NotBlank(message = "Employee code is required") String employeeCode);

    boolean existsByOfficialEmail(@Email(message = "Invalid email format") @NotBlank(message = "Official email is required") String officialEmail);

    boolean existsByPhone(@NotNull(message = "Phone number is required") String phone);
}

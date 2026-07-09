package com.leaveManagement.dto.request;

import com.leaveManagement.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateEmployeeRequest {

    @NotBlank(message = "Employee code is required")
    private String employeeCode;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Date of Joining is required")
    private LocalDate doJ;

    @NotNull(message = "Probation period is required")
    private Integer probation_period;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Official email is required")
    private String official_email;

    @NotNull(message = "Phone number is required")
    private String phone;

    private LocalDate DoB;

    private String address;
}

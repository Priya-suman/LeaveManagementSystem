package com.leaveManagement.dto.response;


import com.leaveManagement.enums.EmployeeStatus;
import com.leaveManagement.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private String employeeCode;

    private String name;

    private Gender gender;

    private LocalDate DoJ;

    private Integer Probation_period;

    private LocalDate DoC;

    private String official_email;

    private EmployeeStatus status;

    private String phone;

    private LocalDate DoB;

    private String address;
}

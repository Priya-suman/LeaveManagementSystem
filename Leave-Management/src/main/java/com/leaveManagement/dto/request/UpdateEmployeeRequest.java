package com.leaveManagement.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateEmployeeRequest {
    private String employeeCode;

    private String name;

    private Integer probation_period;

    private String official_email;

    private String phone;

    private LocalDate DoB;

    private String address;
}

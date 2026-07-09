package com.leaveManagement.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeRequest {

    private String Idy;

    private String name;

    private String gender;

    private LocalDate DoJ;

    private Integer Probation_period;

    private LocalDate DoC;

    private String official_email;

    private String Pan;

    private String Aadhar;

    private String phone;

    private String email;

    private LocalDate DoB;

    private String address;
}

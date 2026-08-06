package com.leaveManagement.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EmployeeDesignationResponse {

    private String DesignationName;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
}

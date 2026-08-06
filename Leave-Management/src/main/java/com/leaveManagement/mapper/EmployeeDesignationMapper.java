package com.leaveManagement.mapper;

import com.leaveManagement.dto.response.EmployeeDesignationResponse;
import com.leaveManagement.entity.EmployeeDesignation;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDesignationMapper {

    public EmployeeDesignationResponse toResponse(EmployeeDesignation employeeDesignation){
        EmployeeDesignationResponse build = EmployeeDesignationResponse.builder()
                .DesignationName(employeeDesignation.getDesignation().getName())
                .effectiveFrom(employeeDesignation.getEffectiveFrom())
                .effectiveTo(employeeDesignation.getEffectiveTo())
                .build();
        return build;
    }
}

package com.leaveManagement.services;

import com.leaveManagement.dto.response.EmployeeDesignationResponse;

import java.util.List;

public interface EmployeeDesignationService {

    List<EmployeeDesignationResponse> accessHistoryByEmpCode(String employeecode);
    
    

}

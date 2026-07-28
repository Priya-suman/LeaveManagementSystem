package com.leaveManagement.mapper;

import com.leaveManagement.dto.request.CreateEmployeeRequest;
import com.leaveManagement.dto.request.UpdateEmployeeRequest;
import com.leaveManagement.dto.response.EmployeeResponse;
import com.leaveManagement.entity.Employee;
import com.leaveManagement.enums.EmployeeStatus;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(CreateEmployeeRequest request){
        return Employee.builder()
                .employeeCode(request.getEmployeeCode())
                .name(request.getName())
                .status(EmployeeStatus.ACTIVE)
                .gender(request.getGender())
                .doJ(request.getDoJ())
                .probationPeriod(request.getProbation_period())
                .officialEmail(request.getOfficial_email())
                .phone(request.getPhone())
                .DoB(request.getDob())
                .address(request.getAddress())
                .build();
    }

    public EmployeeResponse toResponse(Employee employee){
        return EmployeeResponse.builder()
                .employeeCode(employee.getEmployeeCode())
                .name(employee.getName())
                .DoJ(employee.getDoJ())
                .address(employee.getAddress())
                .DoC(employee.getDoC())
                .gender(employee.getGender())
                .official_email(employee.getOfficialEmail())
                .phone(employee.getPhone())
                .DoB(employee.getDoB())
                .status(employee.getStatus())
                .Probation_period(employee.getProbationPeriod())
                .build();
    }

    public void updateEntity(UpdateEmployeeRequest request, Employee employee){
        if(request.getName() != null){
            employee.setName(request.getName());
        }
        if(request.getOfficial_email() != null){
            employee.setOfficialEmail(request.getOfficial_email());
        }
        if(request.getPhone() != null){
            employee.setPhone(request.getPhone());
        }
        if(request.getDoB() != null){
            employee.setDoB(request.getDoB());
        }
        if(request.getProbation_period() != null){
            employee.setProbationPeriod(request.getProbation_period());
        }
        if(request.getAddress() != null){
            employee.setAddress(request.getAddress());
        }
    }
}

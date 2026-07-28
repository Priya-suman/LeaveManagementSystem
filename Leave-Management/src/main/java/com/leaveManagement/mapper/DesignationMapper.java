package com.leaveManagement.mapper;

import com.leaveManagement.dto.request.CreateDesignationRequest;
import com.leaveManagement.dto.response.DesignationResponse;
import com.leaveManagement.entity.Designation;
import com.leaveManagement.enums.DesinationStatus;

public class DesignationMapper {

    public static Designation toEntity(CreateDesignationRequest request) {
        return Designation.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(DesinationStatus.ACTIVE)
                .build();
    }

    public static DesignationResponse toDesignationResponse(Designation designation){
        return DesignationResponse.builder().
                id(designation.getId()).
                name(designation.getName()).
                description(designation.getDescription()).
                status(designation.getStatus()).
                build();
    }
}

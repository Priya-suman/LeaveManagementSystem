package com.leaveManagement.services;

import com.leaveManagement.dto.request.CreateDesignationRequest;
import com.leaveManagement.dto.response.DesignationResponse;

public interface DesignationService {

    public DesignationResponse createDesignation(CreateDesignationRequest request);
}

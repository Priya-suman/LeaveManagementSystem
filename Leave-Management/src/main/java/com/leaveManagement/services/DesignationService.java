package com.leaveManagement.services;

import com.leaveManagement.dto.request.CreateDesignationRequest;
import com.leaveManagement.dto.request.UpdateDesignationRequest;
import com.leaveManagement.dto.response.DesignationResponse;

import java.util.List;
import java.util.Optional;

public interface DesignationService {

    DesignationResponse createDesignation(CreateDesignationRequest request);

    List<DesignationResponse> fetchAllDesig();

    DesignationResponse fetchById(int id);

    DesignationResponse fetchByName(String desig);

    DesignationResponse updateDesignation(UpdateDesignationRequest request);

    void deleteDesignation(String name);

    DesignationResponse activateDesignation(String name);

    DesignationResponse deactivateDesignation(String name);
}

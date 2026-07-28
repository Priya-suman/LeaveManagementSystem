package com.leaveManagement.controller;

import com.leaveManagement.dto.request.CreateDesignationRequest;
import com.leaveManagement.dto.response.DesignationResponse;
import com.leaveManagement.services.DesignationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/designations")
public class DesignationController {

    private final DesignationService designationService;

    @PostMapping
    public DesignationResponse createDesignation(@RequestBody CreateDesignationRequest request) {
        return designationService.createDesignation(request);
    }
}

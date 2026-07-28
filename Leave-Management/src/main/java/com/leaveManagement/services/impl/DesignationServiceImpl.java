package com.leaveManagement.services.impl;

import com.leaveManagement.dto.request.CreateDesignationRequest;
import com.leaveManagement.dto.response.DesignationResponse;
import com.leaveManagement.entity.Designation;
import com.leaveManagement.exceptions.DuplicateDesignationException;
import com.leaveManagement.mapper.DesignationMapper;
import com.leaveManagement.repository.DesignationRepository;
import com.leaveManagement.services.DesignationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class DesignationServiceImpl implements DesignationService {

    private final DesignationRepository designationRepository;

    @Override
    public DesignationResponse createDesignation(CreateDesignationRequest request) {
        /*
        * valdate for duplicate
        * build entity
        * save entity
        * return response
        * */
        validateDuplicate(request);
        Designation designation = DesignationMapper.toEntity(request);
        designationRepository.save(designation);
        return DesignationMapper.toDesignationResponse(designation);
    }

    private void validateDuplicate(CreateDesignationRequest request) {
        if(request.getName() != null && designationRepository.existsByName(request.getName())){
            throw new DuplicateDesignationException("Designation already exist with name : " +request.getName());
        }
    }
}

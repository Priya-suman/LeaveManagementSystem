package com.leaveManagement.services.impl;

import com.leaveManagement.dto.request.CreateDesignationRequest;
import com.leaveManagement.dto.request.UpdateDesignationRequest;
import com.leaveManagement.dto.response.DesignationResponse;
import com.leaveManagement.entity.Designation;
import com.leaveManagement.exceptions.DesignationNotFoundException;
import com.leaveManagement.exceptions.DuplicateDesignationException;
import com.leaveManagement.mapper.DesignationMapper;
import com.leaveManagement.repository.DesignationRepository;
import com.leaveManagement.services.DesignationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    @Override
    public List<DesignationResponse> fetchAllDesig() {
        return designationRepository.findAll().stream().map(DesignationMapper::toDesignationResponse).toList();
    }

    @Override
    public DesignationResponse fetchById(int id) {
        Designation designation = designationRepository.findById(id).orElseThrow(()->new DesignationNotFoundException("Designation not found"));
        return DesignationMapper.toDesignationResponse(designation);
    }

    @Override
    public DesignationResponse fetchByName(String desig) {
        Designation designation =  designationRepository.findByName(desig).orElseThrow(()->new DesignationNotFoundException("Designation not found"));
        return DesignationMapper.toDesignationResponse(designation);
    }

    @Override
    public DesignationResponse updateDesignation(UpdateDesignationRequest request) {
        /*
        * validate the request data
        * Build the entity from request
        * save the entity
        * return response
        * */

        if(request.getId() == null || request.getId() == 0){
            throw new DesignationNotFoundException("Designation doesnot exist with id : "+ request.getId());
        }
        validateUpdateData(request);
        Designation designation = designationRepository.findById(request.getId()).orElseThrow(()->new DesignationNotFoundException("Designation not found"));
        DesignationMapper.updateEntity(request, designation);
        designationRepository.save(designation);
        return DesignationMapper.toDesignationResponse(designation);
    }

    private void validateDuplicate(CreateDesignationRequest request) {
        if(request.getName() != null && designationRepository.existsByName(request.getName())){
            throw new DuplicateDesignationException("Designation already exist with name : " +request.getName());
        }
    }
    private void validateUpdateData(UpdateDesignationRequest request){
        if(request.getName() != null && (request.getName().isBlank() || request.getName().isEmpty())){
            throw new IllegalArgumentException("Name cannot be blank or empty");
        }
        if(request.getDescription() != null && (request.getDescription().isBlank() || request.getDescription().isEmpty())){
            throw new IllegalArgumentException("Description cannot be blank or empty");
        }
    }

    @Override
    public void deleteDesignation(String name) {
        Designation designation = designationRepository.findByName(name).orElseThrow(() -> new DesignationNotFoundException("Designation not found"));
        designationRepository.delete(designation);
    }

    @Override
    public DesignationResponse activateDesignation(String name) {
        Designation designation = designationRepository.findByName(name).orElseThrow(() -> new DesignationNotFoundException("Designation not found"));
        designation.setActive(true);
        designationRepository.save(designation);
        return DesignationMapper.toDesignationResponse(designation);
    }

    @Override
    public DesignationResponse deactivateDesignation(String name) {
        Designation designation = designationRepository.findByName(name).orElseThrow(() -> new DesignationNotFoundException("Designation not found"));
        designation.setActive(false);
        designationRepository.save(designation);
        return DesignationMapper.toDesignationResponse(designation);
    }
}

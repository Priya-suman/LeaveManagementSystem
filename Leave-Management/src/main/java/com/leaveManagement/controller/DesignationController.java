package com.leaveManagement.controller;

import com.leaveManagement.dto.request.CreateDesignationRequest;
import com.leaveManagement.dto.request.UpdateDesignationRequest;
import com.leaveManagement.dto.response.DesignationResponse;
import com.leaveManagement.services.DesignationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/designations")
public class DesignationController {

    private final DesignationService designationService;

    @PostMapping
    public DesignationResponse createDesignation(@RequestBody CreateDesignationRequest request) {
        return designationService.createDesignation(request);
    }

    @GetMapping()
    public ResponseEntity<List<DesignationResponse>> getAllDesignation(){
        return ResponseEntity.ok(designationService.fetchAllDesig());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignationResponse> getById(@PathVariable int id){
        return ResponseEntity.ok(designationService.fetchById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<DesignationResponse> getByName(@PathVariable String name){
        return ResponseEntity.ok(designationService.fetchByName(name));
    }

    @PatchMapping("/update")
    public ResponseEntity<DesignationResponse> updateDesignation(@RequestBody UpdateDesignationRequest request){
        return ResponseEntity.ok(designationService.updateDesignation(request));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteDesignation(@PathVariable String name){
        designationService.deleteDesignation(name);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/activate/{name}")
    public ResponseEntity<DesignationResponse> activateDesignation(@PathVariable String name){
        return ResponseEntity.ok(designationService.activateDesignation(name));
    }

    @PatchMapping("/deactivate/{name}")
    public ResponseEntity<DesignationResponse> deactivateDesignation(@PathVariable String name){
        return ResponseEntity.ok(designationService.deactivateDesignation(name));
    }
}

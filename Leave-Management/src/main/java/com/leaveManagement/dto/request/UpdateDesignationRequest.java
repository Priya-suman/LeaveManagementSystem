package com.leaveManagement.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDesignationRequest {

    private String name;
    private String description;
    private Integer id;
}

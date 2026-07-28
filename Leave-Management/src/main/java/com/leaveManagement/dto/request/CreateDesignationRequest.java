package com.leaveManagement.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDesignationRequest {

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Description is required")
    @NotEmpty(message = "Description cannot be empty")
    private String description;
}

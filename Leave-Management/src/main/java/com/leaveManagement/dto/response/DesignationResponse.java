package com.leaveManagement.dto.response;

import com.leaveManagement.enums.DesinationStatus;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DesignationResponse {

    private Integer id;
    private String name;
    private String description;
    private DesinationStatus status;
}

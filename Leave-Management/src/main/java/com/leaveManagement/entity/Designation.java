package com.leaveManagement.entity;

import com.leaveManagement.enums.DesinationStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="designation")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @Enumerated(EnumType.STRING)
    private DesinationStatus status;

    public void setActive(boolean b) {
        this.status = b ? DesinationStatus.ACTIVE : DesinationStatus.INACTIVE;
    }
}

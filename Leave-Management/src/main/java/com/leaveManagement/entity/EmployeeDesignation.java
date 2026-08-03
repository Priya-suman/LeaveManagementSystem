package com.leaveManagement.entity;

import com.leaveManagement.enums.DesinationStatus;
import com.leaveManagement.enums.EmployeeDesignationStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class EmployeeDesignation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;

    @Column(name = "status", nullable = false)
    private EmployeeDesignationStatus status;

    @Column(name = "effective_from",nullable = false)
    private LocalDate effectiveFrom;

    @Column(name = "effective_to", nullable = true)
    private LocalDate effectiveTo;
}

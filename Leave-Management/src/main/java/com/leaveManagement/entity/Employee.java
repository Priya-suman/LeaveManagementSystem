package com.leaveManagement.entity;

import com.leaveManagement.enums.EmployeeStatus;
import com.leaveManagement.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="employee")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus status;

    @Column(name="employee_code", nullable = false, unique = true)
    private String employeeCode;

    @Column(name="name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="gender", nullable = false)
    private Gender gender;

    @Column(name="DoJ", nullable = false)
    private LocalDate doJ;

    @Column(name="probation_period", nullable = false)
    private Integer probationPeriod;

    @Column(name="DoC")
    private LocalDate DoC;

    @Column(name="official_email", nullable = false, unique = true)
    private String officialEmail;

    @Column(name="phone", nullable = false, unique = true)
    private String phone;

    @Column(name="DoB")
    private LocalDate DoB;

    @Column(name="address")
    private String address;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EmployeeDesignation> employeeDesignation;
//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public static class Builder {
//        Employee employee= new Employee();
//        public Builder employeeCode(String employeeCode) {
//            employee.employeeCode = employeeCode;
//            return this;
//        }
//
//        public Employee build() {
//            return employee;
//        }
//    }
}

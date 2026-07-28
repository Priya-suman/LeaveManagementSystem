package com.leaveManagement.repository;

import com.leaveManagement.entity.Designation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer> {
    boolean existsByName(@NotNull(message = "Name is required") @NotEmpty(message = "Name cannot be empty") String name);
}

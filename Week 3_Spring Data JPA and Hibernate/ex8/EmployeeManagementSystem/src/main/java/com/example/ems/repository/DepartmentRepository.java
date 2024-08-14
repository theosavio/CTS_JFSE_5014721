package com.example.ems.repository;

import com.example.ems.entity.Department;
import com.example.ems.projection.DepartmentProjection;
import com.example.ems.projection.DepartmentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    // Interface-based projection
    List<DepartmentProjection> findByNameContaining(String name);

    // Class-based projection using constructor expression
    @Query("SELECT new com.example.ems.projection.DepartmentSummary(d.id, d.name) FROM Department d WHERE d.name LIKE %:name%")
    List<DepartmentSummary> findDepartmentSummariesByName(String name);
}

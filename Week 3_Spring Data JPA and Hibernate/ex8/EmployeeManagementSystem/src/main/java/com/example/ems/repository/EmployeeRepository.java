package com.example.ems.repository;

import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeProjection;
import com.example.ems.projection.EmployeeSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Interface-based projection
    List<EmployeeProjection> findByNameContaining(String name);

    // Class-based projection using constructor expression
    @Query("SELECT new com.example.ems.projection.EmployeeSummary(e.id, e.name, e.email) FROM Employee e WHERE e.name LIKE %:name%")
    List<EmployeeSummary> findEmployeeSummariesByName(String name);
}

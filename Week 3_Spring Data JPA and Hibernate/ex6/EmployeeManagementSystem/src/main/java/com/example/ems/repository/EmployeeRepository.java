package com.example.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.example.ems.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Find employees by name with pagination and sorting
    Page<Employee> findByNameContaining(String name, Pageable pageable);

    // Find employees by department name with pagination and sorting
    Page<Employee> findByDepartmentNameContaining(String departmentName, Pageable pageable);
}

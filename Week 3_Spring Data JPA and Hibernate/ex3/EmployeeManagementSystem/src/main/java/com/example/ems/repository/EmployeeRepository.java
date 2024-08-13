package com.example.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ems.entity.Employee;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    List<Employee> findByDepartmentId(Integer departmentId);
    
    Employee findByEmail(String email);
    
    List<Employee> findByNameContaining(String name);
}

package com.example.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.ems.entity.Department;
import java.util.*;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    
    Optional<Department> findByName(String name);
    
    @Query("SELECT d FROM Department d WHERE SIZE(d.employees) > 0")
    List<Department> findDepartmentsWithEmployees();
}

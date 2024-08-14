package com.example.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.ems.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.name = ?1")
    List<Employee> findEmployeesByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee findEmployeeByEmail(String email);

    @Query("SELECT e FROM Employee e JOIN e.department d WHERE d.name = ?1")
    List<Employee> findEmployeesByDepartmentName(String departmentName);
}

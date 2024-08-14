package com.example.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.ems.entity.Department;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT d FROM Department d WHERE d.name = ?1")
    Department findDepartmentByName(String name);

    @Query("SELECT d FROM Department d WHERE d.name LIKE %?1%")
    List<Department> findDepartmentsByNameContaining(String namePart);
}

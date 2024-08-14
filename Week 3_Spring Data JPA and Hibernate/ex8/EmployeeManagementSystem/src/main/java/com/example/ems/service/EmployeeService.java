package com.example.ems.service;

import com.example.ems.projection.EmployeeProjection;
import com.example.ems.projection.EmployeeSummary;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeProjection> getEmployeeProjections(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    public List<EmployeeSummary> getEmployeeSummaries(String name) {
        return employeeRepository.findEmployeeSummariesByName(name);
    }
}

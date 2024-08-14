package com.example.ems.controller;

import com.example.ems.projection.EmployeeProjection;
import com.example.ems.projection.EmployeeSummary;
import com.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/projections")
    public List<EmployeeProjection> getEmployeeProjections(@RequestParam String name) {
        return employeeService.getEmployeeProjections(name);
    }

    @GetMapping("/summaries")
    public List<EmployeeSummary> getEmployeeSummaries(@RequestParam String name) {
        return employeeService.getEmployeeSummaries(name);
    }
}

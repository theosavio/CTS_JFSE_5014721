package com.example.ems.projection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EmployeeSummary {

    private final Integer id;
    private final String name;
    private final String email;
}

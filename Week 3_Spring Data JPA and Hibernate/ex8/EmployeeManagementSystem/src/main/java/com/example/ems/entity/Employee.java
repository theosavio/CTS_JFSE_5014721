package com.example.ems.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
}

package com.ccdev.project5.Project5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String surname;
    private float salary;
    private Department department;
    public List<Project> projects;
}

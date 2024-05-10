package com.ccdev.project5.Project5.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {
    private int id;
    private String name;
    List<Employee> employees;
}

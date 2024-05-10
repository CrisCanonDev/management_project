package com.ccdev.project5.Project5.controller;

import com.ccdev.project5.Project5.mapper.DepartmentMapper;
import com.ccdev.project5.Project5.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("departments")
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;


    @GetMapping
    public String listDepartments(Model model) {
        List<Department> departmentList = departmentMapper.getAllDepartments();
        model.addAttribute("departments", departmentList);
        return "departments/departmentsList";
    }

    @GetMapping("/new")
    public String newDepartment(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("action", "/departments/new");
        return "departments/departmentForm";
    }

    @PostMapping("/new")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentMapper.insertDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/{id}")
    public String showDeparmentInformation(@PathVariable int id, Model model) {
        Department department = departmentMapper.getDepartmentById(id);
        model.addAttribute("department", department);
        return "departments/departmentInformation";
    }

    @GetMapping("/{id}/edit")
    public String editDepartment(@PathVariable int id, Model model) {
        Department department = departmentMapper.getDepartmentById(id);
        model.addAttribute("department", department);
        return "departments/departmentForm";
    }

    @PostMapping("/{id}/edit")
    public String updateDepartment(@PathVariable int id,
                                   @ModelAttribute("department") Department department) {
        department.setId(id);
        departmentMapper.updateDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/{id}/delete")
    public String deleteDepartment(@PathVariable int id) {
        departmentMapper.deleteDepartmentById(id);
        return "redirect:/departments";
    }

}

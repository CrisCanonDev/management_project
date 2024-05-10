package com.ccdev.project5.Project5.controller;

import com.ccdev.project5.Project5.mapper.DepartmentMapper;
import com.ccdev.project5.Project5.mapper.EmployeeMapper;
import com.ccdev.project5.Project5.model.Department;
import com.ccdev.project5.Project5.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;


    @GetMapping
    public String employeesList(Model model) {
        List<Employee> employees = employeeMapper.getEmployees();
        model.addAttribute("employees", employees);
        return "employees/employeesList";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        List<Department> departments =  departmentMapper.getAllDepartments();
        model.addAttribute("employee", new Employee());
        model.addAttribute("action", "/employees/new");
        model.addAttribute("departments", departments);
        return "employees/employeeForm";
    }

    @PostMapping("/new")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeMapper.insertEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String editEmployee(@PathVariable int id, Model model) {
        Employee employee = employeeMapper.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("action", "/employees/"+id+"/new");
        return "employees/employeeForm";
    }

    @PostMapping("/{id}/edit")
    public String saveEmployee(@PathVariable int id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeMapper.updateEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable int id) {
        employeeMapper.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}

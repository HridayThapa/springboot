package com.wipro.sprintboot.usecase1.controller;

import com.wipro.sprintboot.usecase1.entity.Employee;
import com.wipro.sprintboot.usecase1.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestParam String name, @RequestParam String role) {
        return employeeService.addEmployee(name, role);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee removed successfully!";
    }
}

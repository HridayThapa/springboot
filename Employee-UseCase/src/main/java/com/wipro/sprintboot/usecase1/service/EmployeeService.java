package com.wipro.sprintboot.usecase1.service;

import com.wipro.sprintboot.usecase1.entity.Employee;
import com.wipro.sprintboot.usecase1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(String name, String role) {
        Employee employee = new Employee(name, role);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        
    }
}

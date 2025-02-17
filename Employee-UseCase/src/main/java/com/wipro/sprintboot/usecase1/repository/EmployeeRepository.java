package com.wipro.sprintboot.usecase1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.sprintboot.usecase1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

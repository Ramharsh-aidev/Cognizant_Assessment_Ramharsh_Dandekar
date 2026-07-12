package com.cognizant.employee.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.cognizant.employee.model.Employee;
import com.cognizant.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}

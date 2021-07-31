package com.hr.employee.employee.service;

import com.hr.employee.employee.exception.EmployeeNotFoundException;
import com.hr.employee.employee.model.Employee;
import com.hr.employee.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees()
    {
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeByid(Long id)
    {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee by ID "+id+" was not found"));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}

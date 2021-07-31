package com.suza.ac.tz.example.repository;

import com.suza.ac.tz.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

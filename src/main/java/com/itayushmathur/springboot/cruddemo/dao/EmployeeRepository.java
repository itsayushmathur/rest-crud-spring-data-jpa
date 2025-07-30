package com.itayushmathur.springboot.cruddemo.dao;

import com.itayushmathur.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

package com.bl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bl.model.EmployeePayroll;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll,Long> {
}

package com.m6.javadevjournal.springbooth2.repository;

import com.m6.javadevjournal.springbooth2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

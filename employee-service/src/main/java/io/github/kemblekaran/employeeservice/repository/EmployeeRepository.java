package io.github.kemblekaran.employeeservice.repository;

import io.github.kemblekaran.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author : Karan Kemble
 * JPA repository which returns data from the database
 * with the help of JPA(Java Persistence API)
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findBySalaryGreaterThan(Double salary);

    List<Employee> findBySalaryLessThan(Double salary);
}

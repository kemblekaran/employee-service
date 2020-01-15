package io.github.kemblekaran.employeeservice.repository;

import io.github.kemblekaran.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    @Query(value = "SELECT * FROM employee_details WHERE salary", nativeQuery = true)
//    List<Employee> findEmployeeBySalary(@PathParam("salary") Double salary, @PathParam("filter") String filter);

    List<Employee> findBySalaryGreaterThan(Double salary);

    List<Employee> findBySalaryLessThan(Double salary);
}

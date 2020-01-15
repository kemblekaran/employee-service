package io.github.kemblekaran.employeeservice.service;

import io.github.kemblekaran.employeeservice.model.Employee;
import io.github.kemblekaran.employeeservice.model.Response;
import io.github.kemblekaran.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Response addNewEmployee(Employee employee) {
        Response response = new Response(201, "Please provide employee details", employee);
        try {
            if (employee == null || !employee.isValid())
                return response;
            Employee persistedEmployee = employeeRepository.save(employee);
            return new Response(200, "employee successfully added", persistedEmployee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public Response getAllEmployees() {
        Response response = null;
        List<Employee> employeeList = null;
        try {
            employeeList = employeeRepository.findAll();

            if (employeeList == null)
                response = new Response(200, "0 employees found", Collections.emptyList());

            response = new Response(200, String.valueOf(employeeList.size()).concat(" employees found"), employeeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public Response getAllEmployeesBySalary(Double salary, String filter) {
        Response response = new Response(200, "0 employees found with salary " + filter + " than " + salary, Collections.emptyList());
        List<Employee> employeeList = null;
        try {
            if (salary == null || filter == null)
                response = new Response(200, "either provide salary or filter", Collections.emptyList());

            switch (filter) {
                case "less":
                    employeeList = employeeRepository.findBySalaryLessThan(salary);
                    break;
                case "greater":
                    employeeList = employeeRepository.findBySalaryGreaterThan(salary);
                    break;
            }

            response = new Response(200,
                    String.valueOf(employeeList.size()).concat(" employees found with salary " + filter + " than " + salary),
                    employeeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}

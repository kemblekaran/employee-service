package io.github.kemblekaran.employeeservice.controller;

import io.github.kemblekaran.employeeservice.model.Employee;
import io.github.kemblekaran.employeeservice.model.Response;
import io.github.kemblekaran.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/")
    public Response addEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @GetMapping(value = "/")
    public Response getAllEmployeeDetails() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/search")
    public Response getEmployeesBySalary(@RequestParam("salary") Double salary, @RequestParam("filter") String filter) {
        return employeeService.getAllEmployeesBySalary(salary, filter);
    }
}

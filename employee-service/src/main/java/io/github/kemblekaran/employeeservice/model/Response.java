package io.github.kemblekaran.employeeservice.model;

import java.util.List;

public class Response {
    private int status;
    private String message;
    private Employee employee;
    private List<Employee> employees;

    public Response() {
    }

    public Response(int status, String message, List<Employee> employees) {
        this.status = status;
        this.message = message;
        this.employees = employees;
    }

    public Response(int status, String message, Employee employee) {
        this.status = status;
        this.message = message;
        this.employee = employee;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

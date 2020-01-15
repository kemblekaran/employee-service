package io.github.kemblekaran.employeeservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Author : Karan Kemble
 * This class is represents @{Employee} and is configured
 * with the JPA(Object Relational Mapping) so that it can
 * be saved in any data source
 */
@Entity
@Table(name = "employee_details", catalog = "employee_service")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "salary")
    private Double salary;

    public Employee() {
    }

    //parameterized constructor for future use
    public Employee(@NotNull String name, @NotNull String email, @NotNull Double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    /**
     * Checks for the empty and null input for all the
     * properties of the @{Employee}
     *
     * @return boolean true if all the input is valid
     */
    public boolean isValid() {
        return (name != null && name.length() > 0) &&
                (email != null && email.length() > 0) &&
                (salary != null && salary >= 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}

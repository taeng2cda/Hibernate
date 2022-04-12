package com.infotech.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name="employee_table")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="employee_Id")
    private Integer employeeId;

    @Column(name="employee_name",length = 100,nullable = false)
    private String employeeName;

    @Column(name="email",unique = true)
    private String email;

    @Column(name="date_of_joining")
    private Date doj;

    @Column(name="salary")
    private Double salary;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

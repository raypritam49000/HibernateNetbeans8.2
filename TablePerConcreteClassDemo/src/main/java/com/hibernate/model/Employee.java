package com.hibernate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "id"))
    ,
@AttributeOverride(name = "name", column = @Column(name = "name"))
    ,
@AttributeOverride(name = "gender", column = @Column(name = "gender"))
})
public class Employee extends Person {

    @Column(name = "salary", columnDefinition = "DECIMAL(7,2)")
    private double salary;

    @Column(name = "dept_name", length = 40)
    private String deptName;

    @Column(name = "bonus", precision = 6, scale = 3)
    private double bonous;

    @Column(name = "email", unique = true, length = 30)
    private String email;

    public Employee() {
    }

    public Employee(double salary, String deptName, double bonous, String email) {
        this.salary = salary;
        this.deptName = deptName;
        this.bonous = bonous;
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public double getBonous() {
        return bonous;
    }

    public void setBonous(double bonous) {
        this.bonous = bonous;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

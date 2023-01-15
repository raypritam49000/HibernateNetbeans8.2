package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private double salary;
    @Embedded
    @AttributeOverrides(value = {
        @AttributeOverride(column = @Column(name = "home_city_name"), name = "city"),
        @AttributeOverride(column = @Column(name = "home_state_name"), name = "state"),
        @AttributeOverride(column = @Column(name = "home_country_name"), name = "country"),
        @AttributeOverride(column = @Column(name = "home_pincode"), name = "pincode"),
    })
    private Address homeAddress;
    @Embedded
     @AttributeOverrides(value = {
        @AttributeOverride(column = @Column(name = "office_city_name"), name = "city"),
        @AttributeOverride(column = @Column(name = "office_state_name"), name = "state"),
        @AttributeOverride(column = @Column(name = "office_country_name"), name = "country"),
        @AttributeOverride(column = @Column(name = "office_pincode"), name = "pincode"),
    })
    private Address officeAddress;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

}

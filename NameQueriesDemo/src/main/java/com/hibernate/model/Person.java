package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

@Entity
@Table(name = "person_table")
@NamedQueries({
    @NamedQuery(name = "getPersonById", query = "select name from Person where id=:id")
    ,
   @NamedQuery(name = "getAllPerson", query = "from Person")
    ,
    @NamedQuery(name = "getMultiAttriPerson",query = "select name,age,salary from Person")
})
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_id", length = 233, nullable = false)
    private int id;
    @Column(name = "person_name", length = 233, nullable = false)
    private String name;
    @Column(name = "person_age", length = 233, nullable = false)
    private int age;
    @Column(name = "person_salary", length = 233, nullable = false)
    private double salary;

    public Person() {
    }

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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
}

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
@Table(name = "student_table")
@NamedQueries({
    @NamedQuery(name="Student.findAll",query = "from Student"),
    @NamedQuery(name="Student.findById",query = "from Student where id =:userId"),
    @NamedQuery(name = "Student.update", query = "update Student set salary = 90000 where id = :id"),
    @NamedQuery(name="TotalStudent",query = "select count(id) as ToatlStudent from Student")
        
})
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "studentId", nullable = false)
    private long id;
    @Column(name = "studentName", nullable = false)
    private String name;
    @Column(name = "studentAge", nullable = false)
    private int age;
    @Column(name = "studentSalary", nullable = false)
    private double salary;

    public Student() {
    }

    public Student(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

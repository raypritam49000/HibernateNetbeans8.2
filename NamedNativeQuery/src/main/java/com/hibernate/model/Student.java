package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "StudentFindById",
            query = "from Student where id =: id")
    ,
    @NamedQuery(name = "AllStudentFind",
            query = "from Student")
    ,
    @NamedQuery(name = "UpdateStudent",
            query = "update Student s set s.salary =: salary where s.id =: id")
    ,
   
    @NamedQuery(name = "DeleteStudent", query = "DELETE FROM Student AS s WHERE s.name=:name AND s.id=:id")
})

@NamedNativeQueries({
        @NamedNativeQuery(name = "getAllStudent",query = "select * from student",resultClass = Student.class),
        @NamedNativeQuery(name="findStudentById",query = "select * from student where id =:id",resultClass = Student.class),
        @NamedNativeQuery(name ="ToatlStudent",query = "select count(id) from student")
})
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    private String name;
    private int age;
    private double salary;

    public Student(String name, int age, double salary) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Student() {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

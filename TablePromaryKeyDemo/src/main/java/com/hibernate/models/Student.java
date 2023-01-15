package com.hibernate.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "stdId_generator")
    @TableGenerator(name="stdId_generator",initialValue = 1,allocationSize = 1,table= "stdId_generator",schema = "hibernatedb")
    private int id;
    private String name;
    private int age;
    private long mobile;
    private String city;

    public Student() {
        super();
    }

    public Student(String name, int age,String city,long mobile) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.mobile = mobile;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

}

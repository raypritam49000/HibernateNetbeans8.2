package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="student")
public class Student extends Person {

    @Column(name = "schoolName", length = 40, nullable = false)
    private String schoolName;
    
    @Column(name = "fee", nullable = false)
    private double fee;
    
    @Column(name = "sectionName", length = 40, nullable = false)
    private String secctionName;

    public Student(String schoolName, double fee, String secctionName) {
        this.schoolName = schoolName;
        this.fee = fee;
        this.secctionName = secctionName;
    }

    public Student() {
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getSecctionName() {
        return secctionName;
    }

    public void setSecctionName(String secctionName) {
        this.secctionName = secctionName;
    }

}

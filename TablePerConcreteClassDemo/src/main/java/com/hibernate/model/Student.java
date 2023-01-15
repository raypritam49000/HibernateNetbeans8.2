package com.hibernate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "id"))
    ,
@AttributeOverride(name = "name", column = @Column(name = "name"))
    ,
@AttributeOverride(name = "gender", column = @Column(name = "gender"))
})
public class Student extends Person {

    @Column(name = "schoolName")
    private String schoolName;

    @Column(name = "fee")
    private double fee;

    @Column(name = "sectionName")
    private String sectionName;

    public Student(String schoolName, double fee, String sectionName) {
        this.schoolName = schoolName;
        this.fee = fee;
        this.sectionName = sectionName;
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

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

}

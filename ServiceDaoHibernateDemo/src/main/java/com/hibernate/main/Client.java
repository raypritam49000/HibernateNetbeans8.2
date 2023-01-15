package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.service.StudentSeviceImp;

public class Client {

    public static void createStudent(StudentSeviceImp studentSeviceImp) {
        studentSeviceImp.createStudent(getStudent());
    }

    public static void getStudentById(StudentSeviceImp studentSeviceImp) {
        Student student = studentSeviceImp.getStudentById(1);
        System.out.println(student.getId() + " " + student.getName() + " " + student.getMobile() + " " + student.getSalary());
    }

    public static void updateStudentById(StudentSeviceImp studentSeviceImp) {
        studentSeviceImp.updateStudentById(1, 90000.00);
    }

    public static void deleteStudentById(StudentSeviceImp studentSeviceImp) {
        studentSeviceImp.deleteStudentById(1);
    }

    public static Student getStudent() {
        Student student = new Student("Pritam Ray", 25, 45000, "raypritam1234@gail.com", 7658845376l);
        return student;
    }

    public static void main(String[] args) {
        StudentSeviceImp studentSeviceImp = new StudentSeviceImp();
        //createStudent(studentSeviceImp);
        //getStudentById(studentSeviceImp);
        updateStudentById(studentSeviceImp);
        getStudentById(studentSeviceImp);
    }

}

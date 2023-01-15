package com.hibernate.service;

import com.hibernate.dao.StudentDaoImp;
import com.hibernate.model.Student;

public class StudentSeviceImp implements StudentService{

    @Override
    public void createStudent(Student student) {
       new StudentDaoImp().addStudent(student);
    }

    @Override
    public Student getStudentById(int studentId) {
        return new StudentDaoImp().fetchStudentById(studentId);
    }

    @Override
    public void updateStudentById(int studentId, double salary) {
        new StudentDaoImp().updateStudentById(studentId, salary);
    }

    @Override
    public void deleteStudentById(int studentId) {
      new StudentDaoImp().deleteStudentById(studentId);
    }
    
}

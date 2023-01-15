package com.hibernate.service;

import com.hibernate.model.Student;

public interface StudentService {
   public abstract void createStudent(Student student);
   public abstract Student getStudentById(int studentId);
   public abstract void updateStudentById(int studentId,double salary);
   public abstract void deleteStudentById(int studentId);
}

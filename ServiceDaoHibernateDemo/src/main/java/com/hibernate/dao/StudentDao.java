package com.hibernate.dao;

import com.hibernate.model.Student;

public interface StudentDao {
   public abstract void addStudent(Student student);
   public abstract Student fetchStudentById(int studentId);
   public abstract void updateStudentById(int studentId,double salary);
   public abstract void deleteStudentById(int studentId);  
}

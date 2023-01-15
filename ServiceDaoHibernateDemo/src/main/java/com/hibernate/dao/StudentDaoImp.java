package com.hibernate.dao;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDaoImp implements StudentDao {

    @Override
    public void addStudent(Student student) {
        try {
            Session session = SessionProvider.getSession();
            Transaction transaction = session.beginTransaction();
            int id = (Integer) session.save(student);
            System.out.println("Student is created with id :: " + id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student fetchStudentById(int studentId) {
        // Student student = null;
        try {
            Session session = SessionProvider.getSession();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                return student;
            } else {
                System.out.println("Student doesn't exists with provideded Id..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStudentById(int studentId, double salary) {
        try {
            Session session = SessionProvider.getSession();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.getTransaction().begin();
                student.setSalary(salary);
                session.getTransaction().commit();
            } else {
                System.out.println("Student doesn't exists with provideded Id..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(int studentId) {
        try {
            Session session = SessionProvider.getSession();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.getTransaction().begin();
                session.delete(student);
                session.getTransaction().commit();
            } else {
                System.out.println("Student doesn't exists with provideded Id..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

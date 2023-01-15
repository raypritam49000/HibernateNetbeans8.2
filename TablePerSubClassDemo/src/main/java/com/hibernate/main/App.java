package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting the Projects.......");
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Employee employee = new Employee(50000,"IT",70000,"ray@gmail.com");
        employee.setName("Raj Kumar");
        employee.setGender("Male");
        
        Student student = new Student("DAV Public School",5000.00,"C");
        student.setName("Rahul Kumar");
        student.setGender("Male");
        
        session.getTransaction().begin();
        session.save(employee);
        session.save(student);
        session.getTransaction().commit();
        
        System.out.println("Table Per SubClass are run Successfully..... ");
    }
  
}

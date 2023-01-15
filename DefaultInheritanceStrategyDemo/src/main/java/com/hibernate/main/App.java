package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.model.Person;
import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting the Projects.......");
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Employee employee = new Employee();
        employee.setName("Raj Kumar");
        employee.setGender("Male");
        employee.setSalary(50000);
        employee.setDeptName("IT");
        employee.setBonous(70000);
        employee.setEmail("ray@gmail.com");
        
        Student student = new Student();
        student.setName("Rahul Kumar");
        student.setGender("Male");
        student.setSchoolName("DAV Public School");
        student.setFee(5000);
        student.setSectionName("C");
        
        session.getTransaction().begin();
        session.save(employee);
        session.save(student);
        session.getTransaction().commit();
        
        System.out.println("Table Per Single Class are run Successfully..... ");
        
    }
  
}

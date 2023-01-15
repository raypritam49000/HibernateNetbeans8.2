package com.hibernate.main;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Address homeAddress = new Address("Ropar","Punjab","India",144533);
        Address officeAddress = new Address("Prem Nagar","Punjab","India",140001);
        Employee employee = new Employee("Pritam Ray",25, 30000);
        employee.setHomeAddress(homeAddress);
        employee.setOfficeAddress(officeAddress);
        
        session.getTransaction().begin();
        
        session.save(employee);
        
        session.getTransaction().commit();
        
        
    }
  
}

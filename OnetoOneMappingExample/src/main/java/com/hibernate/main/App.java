package com.hibernate.main;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Employee employee = new Employee("Pritam Ray",24);
        Address address = new Address("Ropar","Punjab","India");
        employee.setAddress(address);
        address.setEmployee(employee);
        
        session.getTransaction().begin();
        session.save(employee);
        session.save(address);
        session.getTransaction().commit();
    }
  
}

package com.hibernate.main;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Employee employee = new Employee("Pritam Ray",24);
        Address address1 = new Address("Ropar","Punjab","India");
        Address address2 = new Address("Ropar","Punjab","India");
        
        List<Address> addresses = Arrays.asList(address1,address2);
        
        employee.setAddress(addresses);
        address1.setEmployee(employee);
        address2.setEmployee(employee);
      
        
        session.getTransaction().begin();
        session.save(employee);
        session.save(address1);
        session.save(address2);
        session.getTransaction().commit();
    }
  
}

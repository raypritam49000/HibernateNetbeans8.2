package com.hibernate.main;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Address address1 = new Address("Ropar", "Punjab", "India", 144533);
        Address address2 = new Address("Prem Nagar", "Punjab", "India", 140001);
        Employee employee = new Employee("Pritam Ray", 25, 30000);
        employee.getAddress().add(address1);
        employee.getAddress().add(address2);

        session.getTransaction().begin();
        session.save(employee);
        session.getTransaction().commit();
        
    }

}

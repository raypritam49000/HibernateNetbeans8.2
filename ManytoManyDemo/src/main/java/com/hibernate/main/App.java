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

        Employee employee1 = new Employee("Pritam Ray", 24);
        Employee employee2 = new Employee("Omi Verma", 34);
        
        Address address1 = new Address("Ropar", "Punjab", "India");
        Address address2 = new Address("Raj Pura", "Punjab", "India");

        List<Employee> employees = Arrays.asList(employee1, employee2);
        List<Address> addresses = Arrays.asList(address1, address2);

        employee1.setAddress(addresses);
        address2.setEmployee(employees);

        session.getTransaction().begin();
        session.save(employee1);
        session.save(employee2);
        session.save(address1);
        session.save(address2);
        session.getTransaction().commit();
    }

}

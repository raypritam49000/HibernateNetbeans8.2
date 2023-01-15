package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.session.SessionFactoryProvider;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InsertDataDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println(session);

        Employee emp1 = new Employee("Pritam Ray", "ray@gmail.com", 20, 49000.0);
        Employee emp2 = new Employee("Ram Kumar", "ram@gmail.com", 26, 23000.0);
        Employee emp3 = new Employee("Amit Kumar", "amit@gmail.com", 24, 19000.0);
        Employee emp4 = new Employee("Omi Verma", "omiverma@gmail.com", 23, 29000.0);

        session.getTransaction().begin();
        session.save(emp1);
        session.save(emp2);
        session.save(emp3);
        session.save(emp4);
        session.getTransaction().commit();

        Session session1 = sessionFactory.openSession();
        Employee employee1 = (Employee) session1.get(Employee.class, 2);
        System.out.println(employee1.getId() + " " + employee1.getName() + " " + employee1.getSalary());
        session1.close();

        System.out.println("----------------------------------------------------");

        Session session2 = sessionFactory.openSession();
        Employee employee2 = (Employee) session2.get(Employee.class, 2);
        System.out.println(employee2.getId() + " " + employee2.getName() + " " + employee2.getSalary());
        session2.close();

        System.out.println("----------------------------------------------------");

        Session session3 = sessionFactory.openSession();
        Employee employee3 = (Employee) session3.get(Employee.class, 2);
        System.out.println(employee3.getId() + " " + employee3.getName() + " " + employee3.getSalary());
        session3.close();

        System.out.println("----------------------------------------------------");

        Session session4 = sessionFactory.openSession();
        Employee employee4 = (Employee) session4.get(Employee.class, 2);
        System.out.println(employee4.getId() + " " + employee4.getName() + " " + employee4.getSalary());
        session4.close();

        System.out.println("----------------------------------------------------");

        Session session5 = sessionFactory.openSession();
        Employee employee5 = (Employee) session5.get(Employee.class, 2);
        System.out.println(employee5.getId() + " " + employee5.getName() + " " + employee5.getSalary());
        session5.close();

        System.out.println("----------------------------------------------------");

        Session session6 = sessionFactory.openSession();
        Employee employee6 = (Employee) session6.get(Employee.class, 2);
        System.out.println(employee6.getId() + " " + employee6.getName() + " " + employee6.getSalary());
        session4.close();
    }

}

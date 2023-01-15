package com.hibernate.main;

import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Person person1 = new Person("Pritam Ray", 20, 45000.0);
        Person person2 = new Person("Amit Kumar", 24, 55000.0);
        Person person3 = new Person("Raj Kumar", 26, 15000.0);
        Person person4 = new Person("Rahul Kumar", 26, 60000.0);
        Person person5 = new Person("Montu Kumar", 26, 35000.0);

        session.getTransaction().begin();

        session.persist(person1);
        session.persist(person2);
        session.persist(person3);
        session.persist(person4);
        session.persist(person5);

        session.getTransaction().commit();

        Query query1 = session.createNamedQuery("getAllPerson");
        List<Person> persons = query1.getResultList();
        persons.forEach((Person person) -> System.out.println(person.getId() + " " + person.getName() + " " + person.getSalary()));

        Query query2 = session.createNamedQuery("getPersonById");
        query2.setParameter("id", 5);
        String name = (String) query2.getSingleResult();
        System.out.println(name);

    }
}

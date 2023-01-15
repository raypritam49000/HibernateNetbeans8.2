package com.hibernate.main;

import com.hibernate.model.Person;
import java.util.List;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestMain {

    public static void main(String[] args) {
        Session session = Persistence.createEntityManagerFactory("UserDB").createEntityManager().getEntityManagerFactory().unwrap(SessionFactory.class).openSession();
        System.out.println(session);

        List<Person> lists = session.byMultipleIds(Person.class).multiLoad(1, 3, 5);
        for (Person person : lists) {
            if (person != null) {
                System.out.println(person.getId() + " " + person.getName() + " " + person.getSalary() + " " + person.getAge() + " " + person.getGender());
            }
        }
    }

}

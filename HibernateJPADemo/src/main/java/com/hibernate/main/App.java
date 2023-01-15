package com.hibernate.main;

import com.hibernate.model.Person;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UserDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Person person1 = new Person("Pritam Ray", 34, "Male", 45000);
        Person person2 = new Person("Omi Verma", 24, "Male", 15000);
        Person person3 = new Person("Chandan Kumar", 25, "Male", 25000);
        Person person4 = new Person("Amit Kumar", 28, "Male", 18000);
        Person person5 = new Person("Raj Kumar", 54, "Male", 20000);

        List<Person> persons = Arrays.asList(person1, person2, person3, person4, person5);
        entityManager.getTransaction().begin();
        for (Person person : persons) {
            if (person != null) {
                entityManager.persist(person);
            }
        }
        entityManager.getTransaction().commit();
    }
}

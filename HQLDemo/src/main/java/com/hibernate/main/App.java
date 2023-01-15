package com.hibernate.main;

import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Person person1 = new Person("Pritam Ray", 34, "Male", 45000);
        Person person2 = new Person("Omi Verma", 24, "Male", 15000);
        Person person3 = new Person("Chandan Kumar", 25, "Male", 25000);
        Person person4 = new Person("Amit Kumar", 28, "Male", 18000);
        Person person5 = new Person("Raj Kumar", 54, "Male", 20000);

        List<Person> persons = Arrays.asList(person1, person2, person3, person4, person5);
        Transaction transaction = session.beginTransaction();
        for (Person person : persons) {
            if (person != null) {
                session.save(person);
            }
        }
        transaction.commit();

        Query query1 = session.createQuery("from Person");
        List<Person> list = query1.list();
        for (Person person : list) {
            if (person != null) {
                System.out.println(person.getId() + " " + person.getName() + " " + person.getSalary() + " " + person.getAge() + " " + person.getGender());
            }
        }

        Query<Person> query2 = session.createQuery("from Person where id=:personId and salary=:salary", Person.class);
        query2.setInteger("personId", 1);
        query2.setDouble("salary", 45000);

        Person person = (Person) query2.getSingleResult();
        if (person != null) {
            System.out.println(person.getId() + " " + person.getName() + " " + person.getSalary() + " " + person.getAge() + " " + person.getGender());
        }
        
        Query query3 = session.createQuery("select name,salary from Person");
        List<Object[]> lists = query3.list();
        for(Object[] obj : lists){
         String name = (String)obj[0];    
         double salary = (Double)obj[1];
            System.out.println(name+" "+salary);
        }
        

    }

}

package com.hibernate.main;

import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Session.LockRequest;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        LockRequest lockRequest = session.buildLockRequest(LockOptions.READ);

        Person p1 = new Person(23, "Pritam Ray", "Rail", 30000);
        Person p2 = new Person(13, "Ram Kumar", "Prem Nagar", 15000);
        Person p3 = new Person(03, "Amit Kumar", "Asron", 35000);
        Person p4 = new Person(37, "Suraj Mehta", "Ropar", 40000);
        Person p5 = new Person(43, "Raju Kumar", "RajPura", 75000);
        Person p6 = new Person(31, "Montu Mehta", "Bihar", 31000);

        session.getTransaction().begin();
        session.saveOrUpdate(p1);
        session.saveOrUpdate(p2);
        session.saveOrUpdate(p3);
        session.saveOrUpdate(p4);
        session.saveOrUpdate(p5);
        session.saveOrUpdate(p6);
        lockRequest.lock(p1);
        lockRequest.lock(p2);
        lockRequest.lock(p3);
        lockRequest.lock(p4);
        lockRequest.lock(p5);
        lockRequest.lock(p6);
        session.getTransaction().commit();

        System.out.println("------------------------------------------------------------------");
        Query query1 = session.createQuery("from Person");
        List<Person> presons = query1.list();
        presons.forEach(person -> System.out.println(person.getId() + " " + person.getName() + " " + person.getCity() + " " + person.getSalary()));

        System.out.println("------------------------------------------------------------------");
        Query query2 = session.createQuery("select id,name,city,salary from Person");
        List<Object[]> list = query2.list();
        list.forEach((obj) -> {
            System.out.println(obj[0] + " " + obj[1] + " " + obj[2] + " " + obj[3]);
        });

        System.out.println("------------------------------------------------------------------");
        session.getTransaction().begin();
        Query query3 = session.createQuery("update Person set salary = 60000 where id=:id");
        query3.setInteger("id", 3);
        query3.executeUpdate();
        session.getTransaction().commit();
        System.out.println("------------------------------------------------------------------");

        Query query4 = session.createQuery("from Person");
        List<Person> list2 = query4.list();
        list2.forEach((Person obj) -> {
            System.out.println(obj.getId() + " " + obj.getName() + " " + obj.getCity() + " " + obj.getSalary());
        });

        System.out.println("-------------------------------------------------------------------");
        List<Person> list3 = session.byMultipleIds(Person.class).multiLoad(3, 23, 37, 43);
        list3.forEach((Person obj) -> {
            System.out.println(obj.getId() + " " + obj.getName() + " " + obj.getCity() + " " + obj.getSalary());
        });
        System.out.println("------------------------------------------------------------------");
        Query q = session.createQuery("select count(id) from Person");
        Long count = (Long)q.getSingleResult();
        System.out.println("Total Persons : "+count);


    }

}

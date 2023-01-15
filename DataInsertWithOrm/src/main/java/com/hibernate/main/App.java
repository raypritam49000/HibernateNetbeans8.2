package com.hibernate.main;

import com.hibernate.model.Teacher;
import com.hibernate.session.SessionProvider;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.CacheMode;
import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Teacher t1 = new Teacher("Pritam Ray", 45, 8699535682l);
        Teacher t2 = new Teacher("Omi Verma", 35, 904444682l);
        Teacher t3 = new Teacher("Raju Kumar", 45, 679835682l);
        Teacher t4 = new Teacher("Raj Kumar", 28, 9872535682l);
        Teacher t5 = new Teacher("Ajit Kumar", 25, 8690135682l);
        Teacher t6 = new Teacher("Chandan Kumar", 23, 909744682l);
        Teacher t7 = new Teacher("Rahul Kumar", 51, 895835682l);
        Teacher t8 = new Teacher("Rajesh Kumar", 38, 6798535682l);

        Transaction tx = session.beginTransaction();
        session.save(t1);
        session.save(t2);
        session.save(t3);
        session.save(t4);
        session.save(t5);
        session.save(t6);
        session.save(t7);
        session.save(t8);
        tx.commit();

        System.out.println("----------------------------------------------------");

        Object object = session.byId(Teacher.class).getReference(3);
        Teacher teacher = (Teacher) object;
        System.out.println(teacher.getId() + " " + teacher.getName() + " " + teacher.getAge() + " " + teacher.getMobile());

        System.out.println(session.contains(t1));
        System.out.println("----------------------------------------------------");

        List<Teacher> teachers = session.byMultipleIds(Teacher.class).with(CacheMode.NORMAL).multiLoad(1, 6, 8);
        teachers.forEach(person -> System.out.println(person.getId() + " " + person.getName() + " " + person.getMobile()));

        System.out.println("----------------------------------------------------");

        session.byMultipleIds(Teacher.class).multiLoad(1, 5, 7).forEach(
                person -> System.out.println(person.getId() + " " + person.getName() + " " + person.getMobile())
        );

        System.out.println("----------------------------------------------------");

        Teacher teacher1 = (Teacher) session.find(Teacher.class, 8);
        System.out.println(teacher1.getId() + " " + teacher1.getName() + " " + teacher1.getAge() + " " + teacher1.getMobile());

        System.out.println("----------------------------------------------------");

        NaturalIdLoadAccess naturalIdentifier = session.byNaturalId(Teacher.class);
        naturalIdentifier.using("name", "Raju Kumar");
        Teacher teacher2 = (Teacher) naturalIdentifier.getReference();
        System.out.println(teacher2.getId() + " " + teacher2.getName() + " " + teacher2.getMobile());

        System.out.println("----------------------------------------------------");
        Teacher teacher3 = session.bySimpleNaturalId(Teacher.class).setSynchronizationEnabled(true).load("Pritam Ray");
        System.out.println(teacher3.getId() + " " + teacher3.getName() + " " + teacher3.getAge() + " " + teacher3.getMobile());

        System.out.println("----------------------------------------------------");
        Teacher t = session.getReference(Teacher.class, 5);
        System.out.println(t.getId() + " " + t.getName() + " " + t.getAge() + " " + t.getMobile());

        System.out.println("----------------------------------------------------");
        @SuppressWarnings("unchecked")
        List<Teacher> teachers1 = session.createCriteria(Teacher.class).list();
        teachers1.forEach(person -> System.out.println(person.getId() + " " + person.getName() + " " + person.getMobile()));

        System.out.println("----------------------------------------------------");
        Teacher tr2 = (Teacher) session.byId(Teacher.class).load(1);
        System.out.println(tr2.getId() + " " + tr2.getName() + " " + tr2.getAge() + " " + tr2.getMobile());
    }

}

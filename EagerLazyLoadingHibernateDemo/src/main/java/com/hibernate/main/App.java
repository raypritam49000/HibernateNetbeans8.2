package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Student st = new Student("Pritam Ray", 45, "Ropar", 8699535682l);

        session.beginTransaction();

        session.save(st);

        session.getTransaction().commit();

        Student student2 = session.get(Student.class, 1);
        if (student2 != null) {
            System.out.println(student2.getId() + " " + student2.getName() + " " + student2.getMobile());
        }

        Student student1 = session.load(Student.class, 1);
        if (student1 != null) {
            System.out.println(student1.getId() + " " + student1.getName() + " " + student1.getMobile());
        }

    }
}

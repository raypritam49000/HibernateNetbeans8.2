package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.model.Subject;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();

        Student s1 = new Student();
        s1.setS_id(101);
        s1.setS_name("Vipul");
        s1.setS_age(20);

        Student s2 = new Student();
        s2.setS_id(102);
        s2.setS_name("Aman");
        s2.setS_age(22);

        Subject sb1 = new Subject();
        sb1.setName("ENGLISH");
        sb1.setMarks(80);
        sb1.setS_id(345);

        Subject sb2 = new Subject();
        sb2.setName("Maths");
        sb2.setMarks(75);
        sb2.setS_id(567);

        s1.setSub(sb1);
        s2.setSub(sb2);

        session.getTransaction().begin();

        session.persist(s1);
        session.persist(s2);

        session.getTransaction().commit();

        Student student = (Student) session.byId(Student.class).getReference(101);
        if (student != null) {
            session.getTransaction().begin();
            session.delete(student);
            session.getTransaction().commit();
        }
    }

}

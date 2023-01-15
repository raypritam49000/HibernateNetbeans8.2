package com.hibernate.main;

import com.hibernate.models.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Student st1 = new Student("Pritam Ray",45,"Ropar",8699535682l);
        Student st2 = new Student("Omi Verma",34,"Ropar",7675885682l);
        Student st3 = new Student("Chandan Kumar",25,"Ropar",6009455682l);
        
        session.beginTransaction();
        
        session.save(st1);
        session.save(st2);
        session.save(st3);
        
        session.getTransaction().commit();
    }
}

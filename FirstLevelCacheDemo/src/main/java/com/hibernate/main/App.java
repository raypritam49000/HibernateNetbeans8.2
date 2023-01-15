package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Student st1 = new Student("Pritam Ray", 23, 50000);
        Student st2 = new Student("Omi Verma", 33, 34000);
        Student st3 = new Student("Ram Kumar", 22, 15000);
        Student st4 = new Student("Chandan Kumar", 27, 30000);

        session.getTransaction().begin();

        session.save(st1);
        session.save(st2);
        session.save(st3);
        session.save(st4);

        session.getTransaction().commit();

        Student student1 = (Student) session.get(Student.class,4);
        System.out.println(student1.getId()+" "+student1.getName()+" "+student1.getSalary());
        
        Student student2 = (Student) session.get(Student.class,4);
        System.out.println(student2.getId()+" "+student2.getName()+" "+student2.getSalary());
        
        Student student3 = (Student) session.byId(Student.class).getReference(4);
        System.out.println(student3.getId()+" "+student3.getName()+" "+student3.getSalary());
        
    }

}

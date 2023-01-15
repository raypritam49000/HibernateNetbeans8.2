package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {

        Session session = SessionProvider.getSession();

        Student s1 = new Student();
        s1.setS_id(101);
        s1.setS_name("Vipul");
        s1.setS_age(25);
        s1.setSalary(34000);

        session.getTransaction().begin();
        session.save(s1);
        session.getTransaction().commit();
        
        Student student1 = (Student) session.get(Student.class, 101);
        if (student1 != null) {
            System.out.println(student1.getS_id() + " " + student1.getS_name() + " " + student1.getS_age() + " " + student1.getSalary());
        }

        session.evict(s1);
        s1.setS_name("Pritam Ray");
        s1.setS_id(1710421);
        s1.setSalary(50000);

        Student mergedStudent = (Student) session.merge(s1);
        System.out.println(mergedStudent.getS_id() + " " + mergedStudent.getS_name() + " " + mergedStudent.getS_age() + " " + mergedStudent.getSalary());

//        if (s1 != null) {
//            session.getTransaction().begin();
//            session.update(s1);
//            session.getTransaction().commit();
//        }
        Student student2 = (Student) session.get(Student.class, 101);
        if (student2 != null) {
            student2.setS_name("Raj Kumar");
            student2.setSalary(80000);
            session.getTransaction().begin();
            session.update(student2);
            session.getTransaction().commit();
        }

        Student student3 = (Student) session.get(Student.class, 101);
        if (student3 != null) {
            System.out.println(student3.getS_id() + " " + student3.getS_name() + " " + student3.getS_age() + " " + student3.getSalary());
        }
        
    }

}

package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MergeUpdateDemo {

    public static void main(String[] args) {
        Session session1 = SessionProvider.getSession();

        Student student1 = (Student) session1.get(Student.class, 101);
        if (student1 != null) {
            student1.setSalary(70000);
        }

        Session session2 = SessionProvider.getSession();
        Student student2 = (Student) session2.get(Student.class, 101);
        if (student2 != null) {
            Transaction tx = session2.beginTransaction();
            session2.update(student2);
            tx.commit();
        }

        if (student2 != null) {
            System.out.println(student2.getS_id() + " " + student2.getS_name() + " " + student2.getS_age() + " " + student2.getSalary());
        }

    }
}

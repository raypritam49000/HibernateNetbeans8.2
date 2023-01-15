package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import java.util.Iterator;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Student st1 = new Student("Ram Kumar", 23, 56000);
        Student st2 = new Student("Pritam Ray", 33, 46000);
        Student st3 = new Student("Prem Kumar", 21, 26000);
        Student st4 = new Student("Amit Kumar", 33, 36000);

        Transaction tx1 = session.beginTransaction();
        session.save(st1);
        session.save(st2);
        session.save(st3);
        session.save(st4);
        tx1.commit();

        System.out.println("-----------------------------------------------------------------");
        Query query = session.createNamedQuery("Student.findAll");
        Iterator<Student> it = query.iterate();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            System.out.println(student.getName() + " " + student.getAge() + " " + student.getSalary());
        }

        System.out.println("-----------------------------------------------------------------");
        TypedQuery<Student> query1 = session.createNamedQuery("Student.findById", Student.class);
        query1.setParameter("userId", 2l);

        Student student = (Student) query1.getSingleResult();
        System.out.println(student.getName() + " " + student.getAge() + " " + student.getSalary());
        System.out.println("------------------------------------------------------------------");
        Query<Student> query2 = session.createNamedQuery("Student.findById", Student.class);
        //query2.setParameter("userId", 2l);
        query2.setInteger("userId", 3);

        Student student1 = (Student) query2.getSingleResult();
        System.out.println(student1.getName() + " " + student1.getAge() + " " + student1.getSalary());
        System.out.println("--------------------------------------------------------------------");
        session.getTransaction().begin();
        Query query3 = session.getNamedQuery("Student.update");
        query3.setParameter("id", 3l);
        query3.executeUpdate();
        session.getTransaction().commit();

        System.out.println("---------------------------------------------------------------------");
        Student student2 = session.byId(Student.class).getReference(3l);
        if (student2 != null) {
            System.out.println(student2.getName() + " " + student2.getAge() + " " + student2.getSalary());
        }
        else{
            System.out.println("Student does not exits with provideded id");
        }

        System.out.println("----------------------------------------------------------------------");
        Query query4 = session.createNamedQuery("TotalStudent");
        Long totalStudent = (Long) query4.getSingleResult();
        System.out.println("Total Student : " + totalStudent);

    }

}

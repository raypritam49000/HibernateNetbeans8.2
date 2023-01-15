package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Student st1 = new Student("Pritam Ray", 34, 45000.0);
        Student st2 = new Student("Ram Kumar", 24, 15000.0);
        Student st3 = new Student("Omi Verma", 20, 25000.0);
        Student st4 = new Student("Amit Kumar", 14, 20000.0);
        Student st5 = new Student("Ajit Kumar", 24, 15000.0);

        Transaction transaction = session.beginTransaction();
        session.save(st1);
        session.save(st2);
        session.save(st3);
        session.save(st4);
        session.save(st5);
        transaction.commit();

        System.out.println("----------------------------------------------------------------");
        TypedQuery<Student> query = session.createNamedQuery("AllStudentFind", Student.class);
        List<Student> result = query.getResultList();
        result.forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getAge() + " " + e.getSalary()));

        System.out.println("----------------------------------------------------------------");
        Query<Student> query1 = session.createNamedQuery("AllStudentFind", Student.class);
        List<Student> result1 = query1.getResultList();
        result1.forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getAge() + " " + e.getSalary()));

        System.out.println("----------------------------------------------------------------");
        Query<Student> query2 = session.createNamedQuery("StudentFindById", Student.class);
        query2.setParameter("id", 3);
        Student student = (Student) query2.getSingleResult();
        System.out.println(student.getId() + " " + student.getName() + " " + student.getAge() + " " + student.getSalary());

        System.out.println("----------------------------------------------------------------");
        session.getTransaction().begin();
        Query query3 = session.createNamedQuery("UpdateStudent");
        query3.setParameter("salary", 90000.0);
        query3.setParameter("id", 4);
        query3.executeUpdate();
        session.getTransaction().commit();

        System.out.println("-----------------------------------------------------------------");
        Query<Student> query5 = session.createNamedQuery("AllStudentFind");
        List<Student> result5 = query5.getResultList();
        result5.forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getAge() + " " + e.getSalary()));

        System.out.println("-----------------------------------------------------------------");
        session.getTransaction().begin();
        Query query4 = session.createNamedQuery("DeleteStudent");
        query4.setParameter("name", "Pritam Ray");
        query4.setParameter("id", 1);
        int result2 = query4.executeUpdate();
        session.getTransaction().commit();

        System.out.println("------------------------------------------------------------------");
        Query<Student> query6 = session.createNamedQuery("getAllStudent", Student.class);
        List<Student> result6 = query6.list();
        result6.forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getAge() + " " + e.getSalary()));

        System.out.println("-------------------------------------------------------------------");
        NativeQuery query7 = session.getNamedNativeQuery("findStudentById");
        query7.setParameter("id", 2);
        List<Student> student1 = query7.list();
        student1.forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getAge() + " " + e.getSalary()));

        System.out.println("-------------------------------------------------------------------");
        NativeQuery query8 = session.getNamedNativeQuery("ToatlStudent");
        BigInteger count = (BigInteger)query8.getSingleResult();
        System.out.println("TotalStudent : "+count);

    }

}

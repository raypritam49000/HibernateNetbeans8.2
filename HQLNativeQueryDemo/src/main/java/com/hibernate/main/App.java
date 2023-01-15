package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Student st1 = new Student("Pritam Ray", 30000, 23);
        Student st2 = new Student("Omi Verma", 20000, 25);
        Student st3 = new Student("Chandan Kumar", 25000, 28);
        Student st4 = new Student("Raju Kumar", 50000, 26);

        Transaction tx = session.beginTransaction();
        session.save(st1);
        session.save(st2);
        session.save(st3);
        session.save(st4);
        tx.commit();

        List<Student> list = session.createNativeQuery("select * from student").addEntity(Student.class).list();
        list.forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getAge() + " " + e.getSalary()));

        NativeQuery query = session.createNativeQuery("select * from student");
        query.addScalar("id", LongType.INSTANCE);
        query.addScalar("name", StringType.INSTANCE);

        List<Object[]> list1 = query.list();

        for (Object[] obj : list1) {
            Long id = (Long) obj[0];
            String name = (String) obj[1];
            System.out.println(id + " " + name);
        }
    }

}

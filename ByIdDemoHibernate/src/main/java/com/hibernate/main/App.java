package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Student st1 = new Student("Pritam Ray", 23, 7696708539l);
        Student st2 = new Student("Omi Verma", 25, 8696875539l);
        Student st3 = new Student("Raj Kumar", 26, 769845539l);
        Student st4 = new Student("Sham Kumar", 28, 76975668539l);
        Student st5 = new Student("Pritam Ray", 29, 76985348539l);

        Transaction transaction = session.beginTransaction();
        session.save(st1);
        session.save(st2);
        session.save(st3);
        session.save(st4);
        session.save(st5);
        transaction.commit();
        
        Optional<Student> optional=session.byId(Student.class).loadOptional(3);
        if(optional.isPresent()){
            Student student = optional.get();
            System.out.println(student.getId()+" "+student.getName()+" "+student.getAge()+" "+student.getMobile());
        }
        else{
            System.out.println("Student are desn't exists..");
        }
    }

}

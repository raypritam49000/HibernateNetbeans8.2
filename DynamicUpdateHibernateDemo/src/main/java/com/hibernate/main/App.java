package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Student st1 = new Student("Pritam Ray", 34, 45000, "ray123@gmail.com", 8699535682l);
        Student st2 = new Student("Chandan Kumar", 24, 15000, "chadnan453@gmail.com", 700985682l);
        Student st3 = new Student("Omi Verma", 54, 65000, "vermaomi873@gmail.com", 7895535682l);
        Student st4 = new Student("Amit Kumar", 20, 28000, "kumaramit777@gmail.com", 7788995682l);
        Student st5 = new Student("Apurba Ray", 34, 15000, "ray1623@gmail.com", 8699435632l);
        Student st6 = new Student("Chandan Sharma", 24, 35000, "chadnan46553@gmail.com", 910985682l);
        Student st7 = new Student("Raj Kumar", 54, 25000, "verma874333@gmail.com", 986535682l);
        Student st8 = new Student("Amit Sahani", 20, 28000, "amit777@gmail.com", 7755295682l);

        session.getTransaction().begin();

        session.persist(st1);
        session.persist(st2);
        session.persist(st3);
        session.persist(st4);
        session.persist(st5);
        session.persist(st6);
        session.persist(st7);
        session.persist(st8);

        session.getTransaction().commit(); 
        
        
       Student student =(Student)session.get(Student.class,4);
       System.out.println(student.getId()+" "+student.getName()+" "+student.getSalary());
       if(student!=null){
           session.beginTransaction();
           student.setSalary(90000);
           session.getTransaction().commit();
       }
        System.out.println(student.getId()+" "+student.getName()+" "+student.getSalary());
    }
 
}

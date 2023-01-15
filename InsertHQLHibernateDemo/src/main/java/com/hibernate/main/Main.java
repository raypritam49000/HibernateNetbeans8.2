package com.hibernate.main;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println(session);
        String HQL = "insert into Student(id,name,age,mobile,city)"
                + "select id,name,age,mobile,city from BackupStudent";
        Query query = session.createQuery(HQL);
        session.getTransaction().begin();
        int i = query.executeUpdate();
        if(i>0){
            System.out.println(i+" records are insert Successfully....");
        }
        else{
              System.out.println("Data are not insert Successfully....");
        }
        session.getTransaction().commit();
    }

}

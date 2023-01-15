package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println(session);
        
        BackupStudent st = new BackupStudent("Pritam Ray",45,"Ropar",8699535682l);
        
        session.beginTransaction();
        
        session.save(st);
        
        session.getTransaction().commit();
    }
}

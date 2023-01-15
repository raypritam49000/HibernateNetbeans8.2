package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionProvider {
   public static Session session; 
   static{
       session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
   }
   
   public static Session getSession(){
       if(session ==null){
           return session;
       }
       else{
           return session;
       }
   }
}

package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionProvider {
   public static Session getSession(){
       StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
       StandardServiceRegistry serviceRegistry=serviceRegistryBuilder.configure().build();
       Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
       Session session = metadata.buildSessionFactory().openSession();
       return  session;
   } 
}

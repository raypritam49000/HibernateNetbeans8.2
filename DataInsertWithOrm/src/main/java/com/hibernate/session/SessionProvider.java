package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionProvider {

    public static Session session;

    static {
        if (session == null) {
            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
            standardServiceRegistryBuilder.configure("hibernate.cfg.xml");
            StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.build();
            MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
            MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();
            Metadata metadata = metadataBuilder.build();
            SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
            SessionFactory sessionFactory = sessionFactoryBuilder.build();
            session = sessionFactory.openSession();
        }
    }
    
    public static Session getSession(){
        return session;
    }
}

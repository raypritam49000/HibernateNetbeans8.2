package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionProvider {

    public static Session getSession() {
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.configure("hibernate.cfg.xml");
        StandardServiceRegistry standardServiceRegistry = serviceRegistryBuilder.build();
        MetadataSources metadataSource = new MetadataSources(standardServiceRegistry);
        Metadata metadata = metadataSource.buildMetadata();
        SessionFactory sessionFactory=metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}

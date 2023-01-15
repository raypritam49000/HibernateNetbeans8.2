package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionProvider {

    public static Session session = null;

    public static Session getSession() {
        if (session == null) {
            session = new Configuration().configure().buildSessionFactory().openSession();
        } else {
            return session;
        }
        return session;
    }
}

package com.hibernate.main;

import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientTest {

    private static final Logger logger = LogManager.getLogger(ClientTest.class);

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Person person = new Person("Pritam Ray", "ray123@gmail.com", "1234", 1);
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(person);
        logger.info("Person Records are saved sucessfully");
        transaction.commit();
        
        System.out.println("--------------------------------------------------------------");
        Person person1 =(Person)session.get(Person.class,1);
        if(person1!=null){
            session.getTransaction().begin();
            person1.setAccesslevel(2);
            session.getTransaction().commit();
        }
        
        System.out.println("----------------------------------------------------------------");
        session.refresh(person1);
    }
}

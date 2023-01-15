package com.hibernate.main;

import com.hibernate.model.Account;
import com.hibernate.model.Book;
import com.hibernate.model.Organization;
import com.hibernate.session.SessionProvider;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Organization organization1 = new Organization(123, "DCM");
        Organization organization2 = new Organization(353, "IT");

        Book book1 = new Book(432l, "Java", organization1);
        Book book2 = new Book(562l, "Java Script", organization1);
        Book book3 = new Book(122l, "Python", organization1);

        Account account1 = new Account(433l, "Pritam Ray", book1);
        Account account2 = new Account(343l, "Omi Verma", book1);
        Account account3 = new Account(863l, "Chandan Kumar", book1);

        Book book4 = new Book(412l, "C", organization2);
        Book book5 = new Book(572l, "Cpp", organization2);
        Book book6 = new Book(182l, "HTML", organization2);
        
        Account account4 = new Account(673l, "Suraj Mehta", book4);
        Account account5 = new Account(973l, "Raj Kumar", book4);
        Account account6 = new Account(723l, "Amit Kumar", book4);

        session.getTransaction().begin();

        session.persist(organization1);
        session.persist(account1);
        session.persist(account2);
        session.persist(account3);
        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        
        session.persist(organization2);
        session.persist(account4);
        session.persist(account5);
        session.persist(account6);
        session.persist(book4);
        session.persist(book5);
        session.persist(book6);

        session.getTransaction().commit();

        Criteria accountCriteria = session.createCriteria(Account.class, "acc");
        Criteria bookCriteria = accountCriteria.createCriteria("book", "b");
        Criteria orgCriteria = bookCriteria.createCriteria("organization", "org");
        orgCriteria.add(Restrictions.eq("name", "IT"));
        accountCriteria.setProjection(Projections.projectionList().add(Projections.property("id")).add(Projections.property("name")));

        List<Object[]> list = accountCriteria.list();
        list.forEach((element) -> {
            Object[] obj = (Object[]) element;

            System.out.println(obj[0] + " " + obj[1] + " ");
        });
    }

}

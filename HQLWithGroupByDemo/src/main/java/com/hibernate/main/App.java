package com.hibernate.main;

import com.hibernate.model.Book;
import com.hibernate.session.SessionProvider;
import java.util.List;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();

        Book book1 = new Book("Java", "Pritam Ray", 600);
        Book book2 = new Book("Cpp", "Omi Verma", 300);
        Book book3 = new Book("Php", "Chandan Kumar", 500);
        Book book4 = new Book("Java Script", "Deepak Kumar", 400);
        Book book5 = new Book("Angular", "SahoSoft", 9000);

        session.getTransaction().begin();
        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);
        session.getTransaction().commit();

        String hql1 = "from Book as bk order by bk.bookName desc";
        String hql2 = "from Book as bk order by bk.bookName, bk.writer desc";

        List<?> list1 = session.createQuery(hql1).list();
        for (int i = 0; i < list1.size(); i++) {
            Book book = (Book) list1.get(i);
            System.out.println(book.getBookId() + ", " + book.getBookName()
                    + "," + book.getWriter() + ", " + book.getPrice());
        }
        
        String hql3 = "select bk.writer, max(bk.price) from Book as bk group by bk.writer";
        String hql4 = "select bk.writer, max(bk.price) from Book as bk group by bk.writer having avg(bk.price) > 100";
        List<?> list2 = session.createQuery(hql3).list();
		for(int i=0; i<list2.size(); i++) {
			Object[] row = (Object[]) list2.get(i);
			System.out.println(row[0]+", "+ row[1]);
		}
    }
}

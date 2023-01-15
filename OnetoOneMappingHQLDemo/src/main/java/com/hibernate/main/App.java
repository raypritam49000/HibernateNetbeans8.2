package com.hibernate.main;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import static com.hibernate.session.SessionProvider.getSession;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        Session session = getSession();
        System.out.println(session);

        Employee employee = new Employee("Pritam Ray", "ray@gmail.com", 34);
        Address address = new Address("Ropar", "Punjab", "India");
        employee.setAddress(address);

        Transaction transaction = session.beginTransaction();
        session.save(employee);
        session.save(address);
        transaction.commit();

        Query query = session.createQuery("select emp.id,emp.name, add.city,add.state,add.country from Employee as emp " + "left join emp.address as add");

        List l = query.list();
        Iterator it = l.iterator();
        while (it.hasNext()) {
            Object rows[] = (Object[]) it.next();
            System.out.println(rows[0] + " -- " + rows[1] + "--" + rows[2] + "--" + rows[3]);
        }

    }

}

package com.hibernate.main;

import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import org.hibernate.Query;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();

        Person p1 = new Person("Pritam Ray", "ray123@gmail.com", "1998", 1, 23000);
        Person p2 = new Person("Omi Verma", "omi423@gmail.com", "0000", 1, 50000);
        Person p3 = new Person("Raj Kumar", "raj223@gmail.com", "123456", 1, 45000);
        Person p4 = new Person("Chandan Kumar", "chandan12533@gmail.com", "1998pray", 1, 60000);

        session.getTransaction().begin();
        session.persist(p1);
        session.persist(p2);
        session.persist(p3);
        session.persist(p4);
        session.getTransaction().commit();

//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Person.class);
//        Root<Person> root = criteriaQuery.from(Person.class);
//        criteriaQuery.select(root);
//
//        Query query = session.createQuery(criteriaQuery);
//        List<Person> list = query.list();
//        list.forEach(e -> {
//            System.out.println(e.getId() + " " + e.getUsername() + " " + e.getPassword() + " " + e.getAccesslevel());
//        });
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Person.class);
//        Root<Person> root = criteriaQuery.from(Person.class);
//        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), 3));
//
//        Query query = session.createQuery(criteriaQuery);
//        Person person = (Person) query.getSingleResult();
//
//        System.out.println(person.getId() + " " + person.getUsername() + " " + person.getPassword() + " " + person.getAccesslevel());
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(String.class);
//        Root<Person> root = criteriaQuery.from(Person.class);
//        criteriaQuery.select(root.get("username")).where(criteriaBuilder.equal(root.get("id"),1));
//        
//        Query query = session.createQuery(criteriaQuery);
//        String username = (String)query.getSingleResult();
//        System.out.println(username);
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Object[].class);
//        Root<Person> root = criteriaQuery.from(Person.class);
//        Path userroot = root.get("username");
//        Path passroot = root.get("password");
//        criteriaQuery.multiselect(userroot, passroot).where(criteriaBuilder.equal(root.get("id"),2));
//
//        Query query = session.createQuery(criteriaQuery);
//        List<Object[]> list = query.list();
//        list.forEach(e->System.out.println(e[0]+" "+e[1]));
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Double.class);
//        Root<Person> root = criteriaQuery.from(Person.class);
//
//        //criteriaQuery.select(criteriaBuilder.max(root.get("salary")));
//        criteriaQuery.select(criteriaBuilder.min(root.get("salary")));
//
//        Query query = session.createQuery(criteriaQuery);
//        //double max = (Double) query.getSingleResult();
//        //System.out.println("Maximum Salary : "+max);
//        double min = (Double) query.getSingleResult();
//        System.out.println("Minimum Salary : "+min);
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Double.class);
//        Root<Person> root = criteriaQuery.from(Person.class);
//        criteriaQuery.select(criteriaBuilder.sum(root.get("salary")));
//        Query query = session.createQuery(criteriaQuery);
//        
//        double salary = (Double) query.getSingleResult();
//        System.out.println("Total Salary : "+salary);
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Double.class);
//        Root<Person> root = criteriaQuery.from(Person.class);
//        criteriaQuery.select(criteriaBuilder.avg(root.get("salary")));
//        Query query = session.createQuery(criteriaQuery);
//
//        double average = (Double) query.getSingleResult();
//        System.out.println("Average Salary : " + average);
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Person.class);
//        Root<Person> root = criteriaQuery.from(Person.class);
//        criteriaQuery.select(root);
//        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("salary")));
//        //criteriaQuery.orderBy(criteriaBuilder.desc(root.get("salary")));
//
//        Query query = session.createQuery(criteriaQuery);
//        List<Person> list = query.getResultList();
//        list.forEach(e->System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary()));
//        
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Person.class);
//        Root<Person> root = criteriaQuery.from(Person.class);
//        criteriaQuery.select(root);
//        
//        criteriaQuery.where(criteriaBuilder.equal(root.get("name"),"Pritam Ray"));
//        
//        criteriaQuery.where((Expression)criteriaBuilder.between(root.get("id"), 2,4));
//
//        Query query = session.createQuery(criteriaQuery);
//        List<Person> list = query.getResultList();
//        list.forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary()));
        
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
//        Root<Person> root = query.from(Person.class);
//        query.select(root).where(criteriaBuilder.between((Expression)root.get("salary"), 20000.0, 30000.0));
//       
//        List<Person> list = session.createQuery(query).getResultList();
//        list.forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary()));

    }

}

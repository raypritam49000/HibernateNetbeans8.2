package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

public class App {

    public static void getStudentByNames(Session session) {
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.property("name"));
        List<String> names = criteria.list();
        names.forEach(e -> System.out.println("Name : " + e));
    }

    public static void getTotalStudent(Session session) {
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.count("id"));
        List<Long> list = criteria.list();
        list.forEach(count -> System.out.println("No of Students : " + count));
    }

    public static void getId(Session session) {
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.id());
        List<Integer> ids = criteria.list();
        ids.forEach(id -> System.out.println("Id : " + id));
    }

    public static void getToatlSalary(Session session) {

        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.sum("salary"));
        List<Object> sums = criteria.list();
        sums.forEach(total -> System.out.println("Total Salary : " + total));
    }

    public static void getMaxSalary(Session session) {
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.max("salary"));
        List<Double> sList = criteria.list();
        sList.forEach(max -> System.out.println("Maximum Salary : " + max));
    }

    public static void getMinSalary(Session session) {
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.min("salary"));
        List<Double> sList = criteria.list();
        sList.forEach(min -> System.out.println("Minimum Salary : " + min));
    }

    public static void getRowCount(Session session) {
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.alias(Projections.rowCount(), "count"));
        List<Long> sList = criteria.list();
        sList.forEach(count -> System.out.println("Count : " + count));
    }

    public static void getAverageSalary(Session session) {
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.avg("salary"));
        List<Double> avgList = criteria.list();
        avgList.forEach(avg -> System.out.println("Average of Salary : " + avg));
    }

    public static void getMultiAttribute(Session session) {
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.projectionList().add(Projections.id()).add(Projections.property("name")));
        List<Object[]> list = criteria.list();
        list.forEach((element) -> {
            Object[] obj = (Object[]) element;
            System.out.println(obj[0] + " " + obj[1]);
        });
    }

    public static void getAliasRowCount(Session session) {
        Criteria criteria = session.createCriteria(Student.class);
        criteria = criteria.setProjection(Projections.projectionList()
                .add(Projections.groupProperty("salary"))
                .add(Projections.alias(Projections.rowCount(), "count")));
        criteria.addOrder(Order.asc("count"));
        List<Object[]> list = criteria.list();
        list.forEach((element) -> {
            Object[] obj = (Object[]) element;
            System.out.println(obj[0] + " " + obj[1]);
        });
    }

    public static void getWithOutAliasRowCount(Session session) {
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("salary")).add(Projections.rowCount()));
        List<Object[]> list = criteria.list();
        list.forEach((element) -> {
            Object[] obj = (Object[]) element;
            System.out.println(obj[0] + " " + obj[1]);
        });
    }

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Student st1 = new Student("Pritam Ray", 34, 45000, "ray123@gmail.com", 8699535682l);
        Student st2 = new Student("Chandan Kumar", 24, 15000, "chadnan453@gmail.com", 700985682l);
        Student st3 = new Student("Omi Verma", 54, 65000, "vermaomi873@gmail.com", 7895535682l);
        Student st4 = new Student("Amit Kumar", 20, 28000, "kumaramit777@gmail.com", 7788995682l);
        Student st5 = new Student("Apurba Ray", 34, 15000, "ray1623@gmail.com", 8699435632l);
        Student st6 = new Student("Chandan Sharma", 24, 35000, "chadnan46553@gmail.com", 910985682l);
        Student st7 = new Student("Raj Kumar", 54, 25000, "verma874333@gmail.com", 986535682l);
        Student st8 = new Student("Amit Sahani", 20, 28000, "amit777@gmail.com", 7755295682l);

        session.getTransaction().begin();

        session.persist(st1);
        session.persist(st2);
        session.persist(st3);
        session.persist(st4);
        session.persist(st5);
        session.persist(st6);
        session.persist(st7);
        session.persist(st8);

        session.getTransaction().commit();

        App.getStudentByNames(session);
        App.getId(session);
        App.getToatlSalary(session);
        App.getTotalStudent(session);
        App.getMaxSalary(session);
        App.getMinSalary(session);
        App.getRowCount(session);
        App.getAverageSalary(session);
        App.getMultiAttribute(session);
        getAliasRowCount(session);
        getWithOutAliasRowCount(session);

    }
}

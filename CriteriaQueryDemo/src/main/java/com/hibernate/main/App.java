package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

public class App {

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

        Criteria criteria = session.createCriteria(Student.class);

//        criteria.add(Restrictions.between("id", 4, 7));
//        criteria.add(Restrictions.idEq(2));
//        criteria.add(Restrictions.eq("salary", 45000.00));
//        criteria.add(Restrictions.ge("salary", 20000.00));
//        criteria.add(Restrictions.like("name", "%Sahani"));
//        criteria.add(Restrictions.ge("id", 3));
//        criteria.add(Restrictions.eqOrIsNull("id", 5));
//        criteria.add(Restrictions.gt("salary", 60000.45));
//        criteria.add(Restrictions.ilike("name", "%mit%"));
//         criteria.add(Restrictions.in("id",2,6,1));
//         criteria.add(Restrictions.like("name", "Pritam%", MatchMode.START));
//         criteria.add(Restrictions.ne("name", "Pritam Ray"));
//        criteria.add(Restrictions.neOrIsNotNull("name", "Amit Kumar"));
//        criteria.add(Restrictions.neOrIsNotNull("name", "Pritam Ray"));
//        criteria.add(Restrictions.neOrIsNotNull("name", "Omi Verma"));
//        SimpleExpression idExpression = Restrictions.eq("id", 3);
//        SimpleExpression salaryExpression = Restrictions.eq("salary",65000.00);
//        
//        criteria.add(Restrictions.and(idExpression,salaryExpression));
//        criteria.add(Restrictions.or(idExpression,salaryExpression));
//        Conjunction objConjunction = Restrictions.conjunction();
//        /* Add multiple condition separated by AND clause within brackets. */
//        objConjunction.add(Restrictions.eq("name", "Amit Kumar"));
//        objConjunction.add(Restrictions.eq("salary", 28000.00));
//
//        /* Attach Conjunction in Criteria */
//        criteria.add(objConjunction);
//        Disjunction objDisjunction = Restrictions.disjunction();
//         /* Add multiple condition separated by OR clause within brackets. */
//        objDisjunction.add(Restrictions.eq("name", "Amit Kumar"));
//        objDisjunction.add(Restrictions.ge("salary", 40000.00));
//         /* Attach Conjunction in Criteria */
//        criteria.add(objDisjunction);
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "Amit Kumar");
//        map.put("salary", 28000.00);
//        criteria.add(Restrictions.allEq(map));
//        criteria.addOrder(Order.asc("salary"));
//        criteria.addOrder(Order.desc("salary"));
          List<Student> students = criteria.list();

        students.forEach(student -> System.out.println(student.getId() + " " + student.getName() + " " + student.getSalary()));

    }

}

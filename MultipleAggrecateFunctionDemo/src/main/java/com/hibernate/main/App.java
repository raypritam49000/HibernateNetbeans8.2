package com.hibernate.main;

import com.hibernate.model.Employee;
import static com.hibernate.session.SessionProvider.getSession;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        Session session = getSession();
        System.out.println(session);

        Employee employee1 = new Employee("Pritam Ray", "ray@gmail.com", 34, 45999);
        Employee employee2 = new Employee("Raj Kumar", "raj@gmail.com", 24, 25999);
        Employee employee3 = new Employee("Rahul Kumar", "rahul@gmail.com", 34, 55999);
        Employee employee4 = new Employee("Omi Verma", "omi123@gmail.com", 26, 15999);
        Employee employee5 = new Employee("Chandan Kumar", "chqn12345@gmail.com", 28, 75999);

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5);

        Transaction transaction = session.beginTransaction();
        for (Employee employee : employees) {
            if (employee != null) {
                session.save(employee);
            }
        }
        transaction.commit();

        Query query = session.createQuery("SELECT COUNT(e),MAX(e.salary),MIN(e.salary),AVG(e.salary),SUM(e.salary) FROM Employee as e");
        List<Object[]> list = query.list();
        for (Object[] obj : list) {
            Long totalEmp = (Long) obj[0];
            double maxSalary = (Double) obj[1];
            double minSalary = (Double) obj[2];
            double avgSalary = (Double) obj[3];
            double totalSalary = (Double) obj[4];
            System.out.println("Toatal Employee : "+totalEmp);
            System.out.println("MaxSalary : "+maxSalary);
            System.out.println("MinSalary : "+minSalary);
            System.out.println("AvgSalary : "+avgSalary);
            System.out.println("TotalSalary : "+totalSalary);
        }
    }

}

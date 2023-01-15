package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.model.EmployeeStatistics;
import static com.hibernate.session.SessionProvider.getSession;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientTest {

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

        String HQL = "SELECT new com.hibernate.model.EmployeeStatistics(COUNT(e),MAX(e.salary),MIN(e.salary),AVG(e.salary),SUM(e.salary))"+ "From Employee as e";
        Query<EmployeeStatistics> query = session.createQuery(HQL, EmployeeStatistics.class);
        EmployeeStatistics employeeStatistics = query.getSingleResult();
        System.out.println("");
        System.out.println("Toatal Employee : " + employeeStatistics.getTotalEmp());
        System.out.println("MaxSalary : " + employeeStatistics.getMaxSalary());
        System.out.println("MinSalary : " + employeeStatistics.getMinSalary());
        System.out.println("AvgSalary : " + employeeStatistics.getAvgSalary());
        System.out.println("TotalSalary : " + employeeStatistics.getTotalSalary());
    }

}

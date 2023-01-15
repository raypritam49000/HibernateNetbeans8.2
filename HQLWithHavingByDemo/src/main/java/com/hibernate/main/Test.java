package com.hibernate.main;

import com.hibernate.model.Department;
import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        Department department1 = new Department("IT", "Ropar", 30000);
        Department department2 = new Department("DCM", "Rail", 28000);
        Department department3 = new Department("SWARAJ", "Rail", 48000);
        Department department4 = new Department("SOFTWARE DEVELOPMENT", "Chandigrah", 58000);

        Employee employee1 = new Employee("Raj Kumar", "raj345@gmail.com");
        Employee employee2 = new Employee("Pritam Ray", "ray@gmail.com");
        Employee employee3 = new Employee("Sonu Kumar", "kumarsonu@gmail.com");
        Employee employee4 = new Employee("Amit Kumar", "amit43213@gmail.com");
        Employee employee5 = new Employee("Amit Kumar", "amit43213@gmail.com");
        Employee employee6 = new Employee("Ajit Kumar", "ajit213@gmail.com");
        Employee employee7 = new Employee("Aman Kumar", "amankumar13@gmail.com");
        Employee employee8 = new Employee("Chandan Kumar", "chandan43213@gmail.com");

        List<Employee> employess1 = Arrays.asList(employee1, employee2);
        List<Employee> employess2 = Arrays.asList(employee3, employee4);
        List<Employee> employess3 = Arrays.asList(employee5, employee6);
        List<Employee> employess4 = Arrays.asList(employee7, employee8);

        department1.setEmployess(employess1);
        employee1.setDepartment(department1);
        employee2.setDepartment(department1);

        department2.setEmployess(employess2);
        employee3.setDepartment(department2);
        employee4.setDepartment(department2);
        
        department3.setEmployess(employess3);
        employee5.setDepartment(department3);
        employee6.setDepartment(department3);

        department4.setEmployess(employess4);
        employee7.setDepartment(department4);
        employee8.setDepartment(department4);

        session.getTransaction().begin();
        session.save(department1);
        session.save(department2);
        session.save(department3);
        session.save(department4);
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
        session.save(employee5);
        session.save(employee6);
        session.save(employee7);
        session.save(employee8);
        session.getTransaction().commit();
        
        String HQL = "select dept.departmentName, count(emp.id) from Department as dept"
                + " join dept.employess as emp group by dept.departmentName"+""
                + " having dept.departmentName in('IT','DCM','SWARAJ','SOFTWARE DEVELOPMENT')"+"order by count(emp.id) asc";

        Query query = session.createQuery(HQL);
        List<Object[]> list = query.list();
        for (Object[] object : list) {
            String name = (String) object[0];
            Long count = (Long) object[1];
            System.out.println(name + "--------------" + count);
        }
    }
}

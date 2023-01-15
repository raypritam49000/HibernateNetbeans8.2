package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session s = SessionProvider.getSession();
        System.out.println(s);

        Employee employee1 = new Employee("Pritam Ray", "Ropar", "It", 40000);
        Employee employee2 = new Employee("Pritam Ray", "Rail", "IT", 30000);
        Employee employee3 = new Employee("Pritam Ray", "Rail", "Human Resouce", 20000);
        Employee employee4 = new Employee("Pritam Ray", "Asron", "It", 50000);

        s.getTransaction().begin();
        s.save(employee1);
        s.save(employee2);
        s.save(employee3);
        s.save(employee4);
        s.getTransaction().commit();

        /*
        DELIMITER $
CREATE PROCEDURE findAllEmployees ()
    BEGIN
        SELECT * FROM employee;
    END $
DELIMITER ;
         
----- STORED PROCEDURE QUERY #2 -----
DELIMITER $
CREATE PROCEDURE findEmployeeByDepartment (IN emp_department VARCHAR(200))
    BEGIN
        SELECT * FROM employee emp WHERE emp.edept = emp_department;
    END $
DELIMITER ;
 
 
----- STORED PROCEDURE QUERY #3 -----
DELIMITER $
CREATE PROCEDURE findEmployeeCountByDesignation (IN emp_designation VARCHAR(200), OUT designation_count INT(50))
    BEGIN
        SELECT COUNT(*) INTO designation_count FROM employee emp WHERE emp.edesig = emp_designation;
    END $
DELIMITER ;
         */
        System.out.println(":::: Find all employees ::::");

        StoredProcedureQuery allemployees = s.createStoredProcedureQuery("findAllEmployees", Employee.class);

        List<Employee> elist = (List<Employee>) allemployees.getResultList();

        for (Employee employee : elist) {
            System.out.println(employee.toString());
        }

        // Stored procedure query #2
        System.out.println("\n:::: Find employees department wise ::::");

        StoredProcedureQuery department = s.createStoredProcedureQuery("findEmployeeByDepartment", Employee.class);
        department.registerStoredProcedureParameter("emp_department", String.class, ParameterMode.IN);

        String dparam = "It";
        department.setParameter("emp_department", dparam);

        List<Employee> dlist = (List<Employee>) department.getResultList();

        for (Employee employee : dlist) {
            System.out.println(employee.toString());
        }

        // Stored procedure query #3
        System.out.println("\n:::: Find employee count by designation ::::");

        StoredProcedureQuery count = s.createStoredProcedureQuery("findEmployeeCountByDesignation");
        count.registerStoredProcedureParameter("emp_designation", String.class, ParameterMode.IN);
        count.registerStoredProcedureParameter("designation_count", Integer.class, ParameterMode.OUT);

        String param = "Rail";
        count.setParameter("emp_designation", param);
        count.execute();

        Integer employee_count = (Integer) count.getOutputParameterValue("designation_count");
        System.out.println("Employee count for designation= " + param + " is= " + employee_count);

        s.close();
    }
}

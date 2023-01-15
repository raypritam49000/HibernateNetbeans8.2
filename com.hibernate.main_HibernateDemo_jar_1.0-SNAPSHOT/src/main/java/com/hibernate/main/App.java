package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.model.Task;
import com.hibernate.session.SessionProvider;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        Task task1 = new Task("Coding", "Denise");
        Task task2 = new Task("Refactoring", "Rose");
        Task task3 = new Task("Designing", "Denise");
        Task task4 = new Task("Documentation", "Mike");

        List<Task> list1 = Arrays.asList(task1, task2);
        List<Task> list2 = Arrays.asList(task3, task2);
        List<Task> list3 = Arrays.asList(task1, task3);
        List<Task> list4 = Arrays.asList(task2, task4);

        Employee employee1 = new Employee("Diana", list1);
        Employee employee2 = new Employee("Mike", list2);
        Employee employee3 = new Employee("Tim", list4);
        Employee employee4 = new Employee("Jack", list3);

        session.getTransaction().begin();
        session.persist(employee1);
        session.persist(employee2);
        session.persist(employee3);
        session.persist(employee4);
        session.getTransaction().commit();

         //Query query = session.createQuery("SELECT DISTINCT e FROM Employee e INNER JOIN e.tasks t");
         // Query query = session.createQuery("SELECT DISTINCT e FROM Employee e INNER JOIN FETCH e.tasks t");
         Query query = session.createQuery("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.tasks t");
         List<Employee> resultList = query.getResultList();
      for (Employee employee : resultList) {
          System.out.println(employee.getName() + " - " + employee.getTasks());
      }
    }
}

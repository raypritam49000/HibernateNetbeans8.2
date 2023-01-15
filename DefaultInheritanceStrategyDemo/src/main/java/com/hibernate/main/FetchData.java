package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.model.Person;
import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class FetchData {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        Person person = session.get(Person.class, 1);
        if ((person instanceof Person) && (person instanceof Employee)) {
            Employee employee = (Employee) person;
            System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getDeptName() + " " + employee.getGender() + " " + employee.getEmail());
        }

        if ((person instanceof Person) && (person instanceof Student)) {
            Student student = (Student) person;
            System.out.println(student.getId() + " " + student.getName() + " " + student.getFee() + " " + student.getSchoolName() + " " + student.getSectionName());
        }

    }

}

package com.hibernate.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hibernate.model.Student;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UserDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student st1 = new Student("Pritam Ray", "Ropar", 24, 8699535682l, 15000);
		Student st2 = new Student("Omi Verma", "Asron", 28, 9041415682l, 20000);
		Student st3 = new Student("Chandan Kumar", "Rail", 25, 869945672l, 30000);
		Student st4 = new Student("Suraj Mehta", "Prem Nagar", 27, 9056125682l, 24000);
		Student st5 = new Student("Pritam Ray", "Ropar", 32, 8699535682l, 50000);
		Student st6 = new Student("Raj Kumar", "Ropar", 24, 8699535682l, 65000);

		entityManager.getTransaction().begin();

		entityManager.persist(st1);
		entityManager.persist(st2);
		entityManager.persist(st3);
		entityManager.persist(st4);
		entityManager.persist(st5);
		entityManager.persist(st6);

		entityManager.getTransaction().commit();

//		entityManager.getTransaction().begin();

//		Object object = entityManager.find(Student.class, st1.getId());
//		Student student = (Student) object;
//		student.setName("Amit Kumar");
//		entityManager.getTransaction().commit();
//		System.out.println(student.getId() + " " + student.getName() + " " + student.getCity() + " "
//				+ student.getMobile() + " " + student.getAge());

		String sql = "from Student";
		Query query = entityManager.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Student> students = (List<Student>) query.getResultList();
		for (Student st : students) {
			System.out.println(st.getId() + " " + st.getName() + " " + st.getSalary() + " " + st.getCity() + " "
					+ st.getAge() + " " + st.getMobile());
		}

		//Query query2 = entityManager.createQuery("select max(salary) from Student");
		//Query query2 = entityManager.createQuery("select min(salary) from Student");
		//Query query2 = entityManager.createQuery("select sum(salary) from Student");
		//Query query2 = entityManager.createQuery("select avg(salary) from Student");
		//Query query2 = entityManager.createQuery("select distinct(name) from Student");
		Query query2 = entityManager.createQuery("select count(id) from Student");
		List<Student> student = (List<Student>) query2.getResultList();
		System.out.println(student);
	

	}
}

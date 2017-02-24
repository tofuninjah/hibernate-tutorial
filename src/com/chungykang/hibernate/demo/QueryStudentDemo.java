package com.chungykang.hibernate.demo;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chungykang.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			// Start a transaction
			System.out.println("Starting a transaction");
			session.beginTransaction();
			
			// Query Students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// Display the students
			displayStudents(theStudents);
			
			// Query students: lastName = 'Duck'
			theStudents = session.createQuery("from Student s where s.lastName = 'Duck'").getResultList();
			
			displayStudents(theStudents);
			
			
			// Query email like chungykang.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%chungykang.com'").getResultList();
			
			System.out.println("\n\n\nStudents with email like chungykang.com");
			displayStudents(theStudents);
						
			// Query students: lastName = 'Wall' OR firstName = 'Daffy'
			theStudents = session.createQuery("from Student s where s.lastName = 'Wall' OR s.firstName = 'Daffy'").getResultList();
			
			System.out.println("\n\n\nStudents with Last Name of Wall OR First Name of Daffy!");
			displayStudents(theStudents);

			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} 
		
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}

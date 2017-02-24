package com.chungykang.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chungykang.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			int studentId = 1;

			// Now get a new session, and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			Student aStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student");
			aStudent.setFirstName("ScoobyDoo");
									
			// commit the transaction
			session.getTransaction().commit();
			
			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("UPDATE Student s SET s.email = 'abc@123.com' WHERE id = 1")
				.executeUpdate();
			
			// Update email for all students
			session.getTransaction().commit();
			
			
			System.out.println("\nDone!!!");
		} 
		
		finally {
			factory.close();
		}
	}

}

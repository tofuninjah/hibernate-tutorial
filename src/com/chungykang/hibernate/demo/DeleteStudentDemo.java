package com.chungykang.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chungykang.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// Delete the student
			System.out.println("Deleting student: " + aStudent);
			session.delete(aStudent);
									
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("\nDone!!!");
		} 
		
		finally {
			factory.close();
		}
	}

}

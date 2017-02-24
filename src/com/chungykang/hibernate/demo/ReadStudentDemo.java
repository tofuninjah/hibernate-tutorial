package com.chungykang.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chungykang.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Create a student object
			System.out.println("Creating a new Student Object");
			Student newStudent = new Student("Daffy", "Duck", "Daffy.Duck@chungykang.com");
			
			// Start a transaction
			System.out.println("Starting a transaction");
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the student!");
			System.out.println(newStudent);
			session.save(newStudent);
			
			// Commit transaction
			System.out.println("Commiting the transaction");
			session.getTransaction().commit();
			
			// NEW CODE //
			
			// Find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + newStudent.getId());
			
			// Now get a new session, and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + newStudent.getId());
			Student aStudent = session.get(Student.class, newStudent.getId());
			
			System.out.println("Get complete: " + aStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} 
		
		finally {
			factory.close();
		}
	}

}

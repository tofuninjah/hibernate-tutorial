package com.chungykang.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chungykang.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student newStudent = new Student("Paul", "Wall", "paully.wally@chungykang.com");
			
			// Start a transaction
			System.out.println("Starting a transaction");
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the student!");
			session.save(newStudent);
			
			// Commit transaction
			System.out.println("Commiting the transaction");
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} 
		
		finally {
			factory.close();
		}
	}

}

package com.chungykang.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chungykang.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Create three student object
			System.out.println("Creating 3 Student Object");
			Student newStudent1 = new Student("Paul", "Wall", "paully.wally@chungykang.com");
			Student newStudent2 = new Student("Lady", "Gaga", "lady.gaga@chungykang.com");
			Student newStudent3 = new Student("Bonita", "Applebum", "bonita.applebum@chungykang.com");
			
			// Start a transaction
			System.out.println("Starting a transaction");
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the student!");
			session.save(newStudent1);
			session.save(newStudent2);
			session.save(newStudent3);
			
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

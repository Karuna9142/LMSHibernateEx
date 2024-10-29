package com.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*Create Hibernate based application to connect with database.

Entity class as Student with basic student attributes to create and save record to database table 

using persistent object. use Session and SessionFactory interfaces. */

@Entity
class Student
{
  @Id
  private int id;
  private String name;
  private double salary;
  
// Default constructor for the student
public Student() 
{
	super();
}

//parameterized constructor
public Student(int id, String name, double salary) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
}
//getter and setter
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}

}
class StudentDemo
{
	public static void main(String[] args)
	{
		// create connection object
		Configuration c = new Configuration();
		//load configuration
		c.configure("hibernate.cfg.xml");
		
		//build a session factory
		SessionFactory sf = c.buildSessionFactory();
		
		//open a session for the session factory
		Session s = sf.openSession();
		
		//Begin a transaction
		Transaction tr= s.beginTransaction();
		
		//create a new Student
		Student s1 = new Student();
		
		//set student id, name, salary
		s1.setId(101);
		s1.setName("Karuna");
		s1.setSalary(34000.0);
		
		Student s2 = new Student();
		s2.setId(102);
		s2.setName("Prerna");
		s2.setSalary(24000.0);
		
		Student s3 = new Student();
		s3.setId(103);
		s3.setName("Smriti");
		s3.setSalary(44000.0);
		
		//save the student object to the database
		s.save(s1);
		s.save(s2);
		s.save(s3);
		
		//commit the transaction to make the change permanent in the database
		tr.commit();
		
		//close the session
		s.close();
		
	}
}
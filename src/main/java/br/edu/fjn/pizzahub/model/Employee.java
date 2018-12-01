package br.edu.fjn.pizzahub.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 private Integer id;
	 @JoinColumn(nullable = false)
	 @OneToOne(cascade = CascadeType.ALL)
	 private Person person;
	 @Column(nullable = false)
	 private String dateOfBirth;
	 @Column(nullable = false)
	 private double salary;
	 @Column(nullable = false)
	 private String function;
	 @Column(nullable = false)
	 private double weeklyWorkload;
	 @JoinColumn(nullable = false)
	 @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	 private Address address;
	 
	 public Employee() {
		 
	 }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public double getWeeklyWorkload() {
		return weeklyWorkload;
	}

	public void setWeeklyWorkload(double weeklyWorkload) {
		this.weeklyWorkload = weeklyWorkload;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	 
	
	

	 
	
	 
	 
	
}

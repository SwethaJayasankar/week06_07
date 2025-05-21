package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="PAYROLL")
public class PayRollmodel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private double salary;
	
	public PayRollmodel() {
		
	}
	
	public PayRollmodel( double salary, String name) {
		
		this.salary = salary;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	

	public void setId(long id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	@Override
	public String toString() {
		return "PayRollmodel{" +
				"id=" + id +
				", name='" + name + '\'' +
				", salary=" + salary +
				'}';
	}

}

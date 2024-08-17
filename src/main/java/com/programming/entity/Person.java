package com.programming.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)//without specifying that mapped by it is owning the relationship
	@JoinTable(name = "person_car", joinColumns = @JoinColumn(name="person_id"), 
	inverseJoinColumns = @JoinColumn(name="car_id"))
	private List<Car> cars = new ArrayList<Car>();
	
	public List<Car> getCars() {
		return cars;
	}
	public void addCar(Car cars) {
		this.cars.add(cars);
	}
	
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	

}

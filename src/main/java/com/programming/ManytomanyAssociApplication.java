package com.programming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.programming.entity.Car;
import com.programming.entity.Person;
import com.programming.repo.CarJpaRepo;
import com.programming.repo.PersonJpaRepo;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class ManytomanyAssociApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyAssociApplication.class, args);
	}
	@Autowired
	private PersonJpaRepo personJpaRepo;
	@Autowired
	private CarJpaRepo carJpaRepo;
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
		//person1Cars();
		
		//person2Cars();
		
		/*Person person = personJpaRepo.findById(2L).get();
	    System.out.println("Person Details: "+person);
	    System.out.println("Car Details: " +person.getCars());*/
		
		Car car = carJpaRepo.findById(1L).get();
		System.out.println("Car Details:"+car);
		System.out.println("Person Details:" +car.getPersons());
		
	}
	private void person2Cars() {
		Car car1 = new Car();
		car1.setName("Volvo");
		
		Person person2 = new Person();
		person2.setName("Kausar");
		person2.addCar(car1);
		personJpaRepo.save(person2);
	}
	private void person1Cars() {
		Car car1 = new Car();
		car1.setName("BMW");
		
		Car car2 = new Car();
		car2.setName("Audi");
		
		Person person1 = new Person();
		person1.setName("Mubashar");
		//person.setCars("Audi");
		person1.addCar(car1);
		person1.addCar(car2);
		personJpaRepo.save(person1);
	}

}
 
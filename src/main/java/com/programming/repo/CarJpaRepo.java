package com.programming.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programming.entity.Car;

@Repository
public interface CarJpaRepo extends JpaRepository<Car, Long> {
	
}

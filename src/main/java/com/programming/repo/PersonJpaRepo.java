package com.programming.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programming.entity.Person;
@Repository
public interface PersonJpaRepo extends JpaRepository<Person, Long> {

}

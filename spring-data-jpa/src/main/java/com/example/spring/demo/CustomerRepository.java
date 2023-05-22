package com.example.spring.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
	List<Customer> findByAge(int age);
	Optional<Customer> findById(Long id);
}

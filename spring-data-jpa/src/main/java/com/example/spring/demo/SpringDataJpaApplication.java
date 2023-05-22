package com.example.spring.demo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {
	
	public static final Logger log =LoggerFactory.getLogger(SpringDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	
	  @Bean
	  public CommandLineRunner demo(CustomerRepository repository) {
	    return (args) -> {
	      // save a few customers
	      repository.save(new Customer("Jack", "Bauer"));
	      repository.save(new Customer("Chloe", "O'Brian"));
	      repository.save(new Customer("Kim", "Bauer"));
	      repository.save(new Customer("David", "Palmer"));
	      repository.save(new Customer("Michelle", "Dessler"));
	      
	      repository.save(new Customer("Phil", "Colson",37));
	      repository.save(new Customer("Jemma", "Simmons",46));
	      repository.save(new Customer("Kim", "Kardation",83));
	      repository.save(new Customer("David", "Schwimmer",46));
	      repository.save(new Customer("Michelle", "O'Bama",47));
	      

	      // fetch all customers
	      log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	      for (Customer customer : repository.findAll()) {
	        log.info(customer.toString());
	      }
	      log.info("");
	      
	      // fetch all customers
	      log.info("Customers found with findByAge(46):");
	      log.info("-------------------------------");
	      for (Customer customer : repository.findByAge(46)) {
	        log.info(customer.toString());
	      }
	      log.info("");

	      // fetch an individual customer by ID
	      Optional<Customer> customer = repository.findById(6L);
	      
	      log.info("Customer found with findById(6L):");
	      log.info("--------------------------------");
	      log.info(customer.map(Customer::toString).orElse("Value was not found in the Database"));
	      log.info("");
	      
	   
	      

	      // fetch customers by last name
	      log.info("Customer found with findByLastName('Bauer'):");
	      log.info("--------------------------------------------");
	      repository.findByLastName("Bauer").forEach(bauer -> {
	        log.info(bauer.toString());
	      });
	      // for (Customer bauer : repository.findByLastName("Bauer")) {
	      //  log.info(bauer.toString());
	      // }
	      log.info("");
	    };
	  }

}

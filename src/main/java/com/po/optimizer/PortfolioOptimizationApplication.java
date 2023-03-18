package com.po.optimizer;


import java.util.ArrayList;
import java.util.List;

import com.po.optimizer.repository.SPDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@SpringBootApplication
@EnableMongoRepositories
public class PortfolioOptimizationApplication implements CommandLineRunner{
	
	//@Autowired
	//ItemRepository groceryItemRepo;
	@Autowired
	SPDataRepository spDataRepository;
	
	//@Autowired
	//CustomItemRepository customRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(PortfolioOptimizationApplication.class, args);
	}
	
	public void run(String... args) {
		
		// Clean up any previous data
		//groceryItemRepo.deleteAll(); // Doesn't delete the collection
		System.out.println("\n-------------------THANK YOU---------------------------");
		System.out.println(spDataRepository.findBySector("Electronic Technology"));
		System.out.println(spDataRepository.count());

	}
	
	// CRUD operations

}


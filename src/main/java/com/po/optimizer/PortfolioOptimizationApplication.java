package com.po.optimizer;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceivedMessageContext;
import com.po.optimizer.repository.SPDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.util.concurrent.TimeUnit;
//import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableMongoRepositories
//@EnableJms
public class PortfolioOptimizationApplication implements CommandLineRunner{

	@Autowired
	SPDataRepository spDataRepository;

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

	/*static void receiveMessages() throws InterruptedException
	{
		CountDownLatch countdownLatch = new CountDownLatch(15);

		// Create an instance of the processor through the ServiceBusClientBuilder
		ServiceBusProcessorClient processorClient = new ServiceBusClientBuilder()
				.connectionString(connectionString)
				.processor()
				.queueName(QUEUE_NAME)
				.processMessage(PortfolioOptimizationApplication::processMessage)
				//.processError(context -> processError(context, countdownLatch))
				.buildProcessorClient();

		System.out.println("Starting the processor");
		processorClient.start();

		TimeUnit.SECONDS.sleep(10);
		System.out.println("Stopping and closing the processor");
		processorClient.close();
	}
	private static void processMessage(ServiceBusReceivedMessageContext context) {
		ServiceBusReceivedMessage message = context.getMessage();
		System.out.printf("Processing message. Session: %s, Sequence #: %s. Contents: %s%n", message.getMessageId(),
				message.getSequenceNumber(), message.getBody());
	}
*/


}


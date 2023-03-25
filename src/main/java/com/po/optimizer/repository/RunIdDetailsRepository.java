package com.po.optimizer.repository;

import com.po.optimizer.model.RunIdDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface RunIdDetailsRepository extends MongoRepository<RunIdDetails, String> {
	
	@Query("{'runId':?0}")
	RunIdDetails findItemByRunId(long runId);

	@Query("{'name':?0}")
	List<RunIdDetails> findItemByName(String name);
	
/*	@Query(value="{runId:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<RunIdDetails> findAll(String category);*/
	
	public long count();

}

package com.po.optimizer.repository;

import com.po.optimizer.model.Optimizersummary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OptimizersummaryRepository extends MongoRepository<Optimizersummary, String> {

    @Query("{runid : ?0}")
    Optimizersummary getOptimizersummarysByRunid(long runid);


}

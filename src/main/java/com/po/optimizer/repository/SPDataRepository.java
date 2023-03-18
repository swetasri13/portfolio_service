package com.po.optimizer.repository;



import com.po.optimizer.model.SnPConstituentData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface SPDataRepository extends MongoRepository<SnPConstituentData, String> {

    @Query("{'Sector':?0}")
    List<SnPConstituentData> findBySector(String Sector);

    @Query("{'Market_Cap':?0}")
    List<SnPConstituentData> findByMarketCap(String Market_Cap);
    @Query(value="{'Sector':?0,'Market_Cap':?1}")
    List<SnPConstituentData> findAllBy(String Sector, String Market_Cap);
    List<SnPConstituentData> findAll();

   /* @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<GroceryItem> findAll(String category);*/

    public long count();
}

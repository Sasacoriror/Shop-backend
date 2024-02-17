package com.example.shopbackend.repository;

import com.example.shopbackend.model.shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface dataRepository extends JpaRepository<shop, Long> {
    //https://stackoverflow.com/questions/38881434/how-to-call-mysql-function-from-spring-data-repositories
    Logger log = LoggerFactory.getLogger(dataRepository.class);

    //Fetching from database
    @Query(value = "select * from shop", nativeQuery = true)
    List<shop> allData();

    @Query(value = "select item, price from shop", nativeQuery = true)
    List<Object[]> selectData();

    @Query(value = "select item, black_friday_price from shop ", nativeQuery = true)
    List<Object[]> saleData();

    //Logging every fetch and error
    default List<shop> all_Data(){
        try {
            List<shop> data = allData();
            log.info("Fetching all data from shop table");
            return data;
        }catch (Exception e){
            log.error("An ERROR occurred while trying to fetch all the data from the table shop: {}", e.getMessage());
            return null;
        }
    }

    default List<Object[]> select_Data(){
        try {
            List<Object[]> data = selectData();
            log.info("Fetching item and price from shop table");
            return data;
        } catch (Exception e){
            log.error("An ERROR occurred fetchig item and price from table shop: {}", e.getMessage());
            return null;
        }
    }

    default List<Object[]> sale_Data(){
        try {
            List<Object[]> data = saleData();
            log.info("Fetching item and blackFridayPrice from table shop");
            return data;
        } catch (Exception e){
            log.error("An ERROR occured fetching item and blackFridayPrice from table shop: {}", e.getMessage());
            return null;
        }
    }
}

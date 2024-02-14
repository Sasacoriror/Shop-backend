package com.example.shopbackend.repository;

import com.example.shopbackend.model.shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface dataRepository  extends JpaRepository<shop, Long> {
    public static final Logger log = LoggerFactory.getLogger(dataRepository.class);

    @Query(value = "select * from shop", nativeQuery = true)
    List<shop> allData();

    default List<shop> all_Data(){
        try {
            List<shop> data = allData();
            log.info("All data fetched from database succesfully");
            return data;
        }catch (Exception e){
            log.error("An error occurred while trying to fetch all the data from the database: {}", e.getMessage());
            return null;
        }
    }

    @Query(value = "select item, price from shop", nativeQuery = true)
    List<Object[]> selectData();
}

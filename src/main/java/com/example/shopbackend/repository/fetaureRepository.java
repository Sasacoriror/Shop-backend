package com.example.shopbackend.repository;

import com.example.shopbackend.model.enabled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface fetaureRepository extends JpaRepository<enabled, Long> {

    Logger logg = LoggerFactory.getLogger(fetaureRepository.class);

    @Query(value = "select enabled_value from enabled", nativeQuery = true)
    boolean value();

    default boolean saleValue(){
        try {
            boolean data = value();
            logg.info("Fetching boolean value from table enabled");
            return data;
        } catch (Exception e){
            logg.error("An ERROR occured fetching boolean value from enabled table: {}", e.getMessage());
            return true;
        }
    }
}

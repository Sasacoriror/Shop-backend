package com.example.shopbackend.repository;

import com.example.shopbackend.model.shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface dataRepository  extends JpaRepository<shop, Long> {

    @Query(value = "select * from shop", nativeQuery = true)
    List<shop> allData();

    @Query(value = "select item, price from shop", nativeQuery = true)
    List<Object[]> selectData();
}

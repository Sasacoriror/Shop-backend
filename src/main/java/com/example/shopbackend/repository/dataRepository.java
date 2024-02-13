package com.example.shopbackend.repository;

import com.example.shopbackend.model.shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface dataRepository  extends JpaRepository<shop, Long> {
}

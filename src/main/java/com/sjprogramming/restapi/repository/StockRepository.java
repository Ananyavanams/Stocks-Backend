package com.sjprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogramming.restapi.entity.stock;

public interface StockRepository extends JpaRepository<stock, Integer> {

}

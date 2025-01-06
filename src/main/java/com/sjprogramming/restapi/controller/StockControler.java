package com.sjprogramming.restapi.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sjprogramming.restapi.entity.stock;
import com.sjprogramming.restapi.repository.StockRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class StockControler {
	
	@Autowired
	StockRepository repo;
	//get all the students 
	//localhost:9092/stocks
	@GetMapping("/stocks") 
	public List<stock> getAllStocks(){
		List<stock> Stocks = repo.findAll();	
		return Stocks;
	}
	//localhost:9092/stocks/1
	@GetMapping("/stocks/{id}")
	public ResponseEntity<stock> getstocks(@PathVariable int id) {
		stock stockid = repo.findById(id).get();	
		return ResponseEntity.ok(stockid);
	}
	
	@PostMapping("/stocks")
	@ResponseStatus(code= HttpStatus.CREATED)
	public void createStock(@RequestBody stock stock) {
		repo.save(stock);
	}
	@PutMapping("/stocks/{id}")
	public ResponseEntity<stock> updateStock(@PathVariable int id,@RequestBody stock stockDetails){
		stock Stock=repo.findById(id).get();
		
		Stock.setName(stockDetails.getName());
		Stock.setQuantity(stockDetails.getQuantity());
		Stock.setPrice(stockDetails.getPrice());

		stock updatedstock = repo.save(Stock);
		return ResponseEntity.ok(updatedstock);
	}
	
	@DeleteMapping("/stocks/{id}")
	public ResponseEntity<Map<String, Boolean>> removestock(@PathVariable int id) {
		stock Stock = repo.findById(id).get();
		repo.delete(Stock);
		Map<String,Boolean> response =new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
	
	

}

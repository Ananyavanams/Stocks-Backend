package com.sjprogramming.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stock")
public class stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="stock_name")
	private String name;
	@Column(name="stock_quantity")
	private int quantity;
	@Column(name="stock_price")
	private int price;
	
	public stock() {
		// TODO Auto-generated constructor stub
	}
	
	public stock(String name, int quantity, int price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "stock [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	

}

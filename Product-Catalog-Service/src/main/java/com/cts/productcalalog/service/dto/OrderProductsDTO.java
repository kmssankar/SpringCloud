package com.cts.productcalalog.service.dto;

public class OrderProductsDTO {
	
	int id;
	int productId;
	int quantity;
	String productName;
	double pricePerItem;
	double price;
	
	
	
	public OrderProductsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderProductsDTO(int id, int productId, int quantity, double pricePerItem, double price ,String productName) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
		this.productName=productName;
		this.price = price;
	}
	
	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

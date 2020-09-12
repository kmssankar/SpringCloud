package com.cts.products.orderservice.dto;

public class OrderProductsDTO {
	
	int id;
	int productId;
	int quantity;
	double pricePerItem;
	double price;
	
	public OrderProductsDTO(int id, int productId, int quantity, double pricePerItem, double price) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
		this.price = price;
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

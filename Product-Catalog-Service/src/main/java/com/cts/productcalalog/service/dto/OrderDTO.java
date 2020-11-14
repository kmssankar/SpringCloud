package com.cts.productcalalog.service.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {

	int id;
	String user;
	double total;
	Date orderDate;
	int totalItems;
	List<OrderProductsDTO> orderproducts;
	
	public OrderDTO() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public List<OrderProductsDTO> getOrderproducts() {
		return orderproducts;
	}
	public void setOrderproducts(List<OrderProductsDTO> orderproducts) {
		this.orderproducts = orderproducts;
	}
}
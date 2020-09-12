package com.cts.products.orderservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue
	int id;
	String user;
	double total;
	@Temporal(TemporalType.DATE)
	Date orderDate;
	int totalItems;
	
	@OneToMany(mappedBy = "order", cascade = {
	        CascadeType.ALL
	    })
	List<OrderProducts> orderproducts;
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

	public List<OrderProducts> getOrderproducts() {
		return orderproducts;
	}

	public void setOrderproducts(List<OrderProducts> orderproducts) {
		this.orderproducts = orderproducts;
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
	
}

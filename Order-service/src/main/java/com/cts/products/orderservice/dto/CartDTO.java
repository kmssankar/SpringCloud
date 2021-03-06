package com.cts.products.orderservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = CartDTO.class)
public class CartDTO {

	int id;
	String user;
	List<CartProductsDTO> cartproducts;
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
	public List<CartProductsDTO> getCartproducts() {
		return cartproducts;
	}
	public void setCartproducts(List<CartProductsDTO> cartproducts) {
		this.cartproducts = cartproducts;
	}
	
	
}

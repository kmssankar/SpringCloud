package com.cts.products.cartservice.dto;

import java.util.List;


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

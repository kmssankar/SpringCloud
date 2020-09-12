package com.cts.products.cartservice.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cart {

	@Id
	@GeneratedValue
	int cartId;
	String user;
	@OneToMany(mappedBy = "cart", cascade = {
	        CascadeType.PERSIST
	    })
	List<CartProducts> cartproducts;

	

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<CartProducts> getCartproducts() {
		return cartproducts;
	}

	public void setCartproducts(List<CartProducts> cartproducts) {
		this.cartproducts = cartproducts;
	}
	
}

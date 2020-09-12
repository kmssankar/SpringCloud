package com.cts.products.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.products.cartservice.domain.CartDomain;
import com.cts.products.cartservice.dto.CartDTO;
import com.cts.products.cartservice.entities.Cart;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	CartDomain cartDomain;
	
	@PostMapping("/cart")
	public String addTocart(@RequestBody Cart cart) {
		if(cartDomain.addAnewCart(cart)) {
		return "added successfully";}
		else {
			return "addition to cart Failed";
		}
	}
	
	@PutMapping("/cart")
	public String updatecart(@RequestBody Cart cart) {
		if(cartDomain.updateCart(cart)) {
		return "update cart successfully";}
		else {
			return "Update to cart Failed";
		}
	}
	
	@GetMapping("/cart/{id}")
	public CartDTO getcart(@PathVariable int id) {
		return cartDomain.getCart(id);
	}
}

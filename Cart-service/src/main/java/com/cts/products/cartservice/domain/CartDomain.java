package com.cts.products.cartservice.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.products.cartservice.dto.CartDTO;
import com.cts.products.cartservice.dto.CartProductsDTO;
import com.cts.products.cartservice.entities.Cart;
import com.cts.products.cartservice.entities.CartProducts;
import com.cts.products.cartservice.repository.CartProductRepository;
import com.cts.products.cartservice.repository.CartRepository;

@Service
public class CartDomain {
	@Autowired
	CartRepository cartRepository;
	
	@Autowired 
	CartProductRepository cartProductRepository;

	public boolean addAnewCart(Cart cart) {
		Cart cartTosave = new Cart();
		cartTosave.setUser(cart.getUser());
		List<CartProducts> cartproducts = new ArrayList<>();
		for (CartProducts cartpoduct : cart.getCartproducts()) {
			CartProducts cartProducts = new CartProducts();
			cartProducts.setProductId(cartpoduct.getProductId());
			cartProducts.setQuantity(cartpoduct.getQuantity());
			cartProducts.setCart(cartTosave);
			cartproducts.add(cartProducts);
		}
		cartTosave.setCartproducts(cartproducts);
		cartRepository.save(cartTosave);
		return true;
	}

	public boolean updateCart(Cart cart) {
		System.out.println("Cart for Update "+ cart.getCartId());
		Cart cartForUpdate = cartRepository.findById(cart.getCartId()).orElse(null);
		if(cartForUpdate !=null) {
		cartForUpdate.setUser(cart.getUser());
		for (CartProducts cartpoduct : cart.getCartproducts()) {
			CartProducts cartProducts = cartProductRepository.findById(cartpoduct.getId()).get();
			cartProducts.setProductId(cartpoduct.getProductId());
			cartProducts.setQuantity(cartpoduct.getQuantity());
		    cartProductRepository.save(cartProducts);
		}
		cartRepository.save(cartForUpdate);
		return true;
		}
		return false;
	}

	public CartDTO getCart(int id) {
		CartDTO catCartDTO = new CartDTO();

		Cart cart = cartRepository.findById(id).orElse(null);
		if (cart != null) {
			catCartDTO.setId(cart.getCartId());
			catCartDTO.setUser(cart.getUser());
			List<CartProductsDTO> cartProductsDTOs = new ArrayList<>();
			for (CartProducts cartProd : cart.getCartproducts()) {
				CartProductsDTO cartProductsDTO = new CartProductsDTO();
				cartProductsDTO.setId(cartProd.getId());
				cartProductsDTO.setProductId(cartProd.getProductId());
				cartProductsDTO.setQuantity(cartProd.getQuantity());
				cartProductsDTOs.add(cartProductsDTO);
			}
			catCartDTO.setCartproducts(cartProductsDTOs);
		}
		return catCartDTO;
	}
}

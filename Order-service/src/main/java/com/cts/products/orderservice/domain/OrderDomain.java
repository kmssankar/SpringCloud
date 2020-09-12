package com.cts.products.orderservice.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.products.orderservice.dto.CartDTO;
import com.cts.products.orderservice.dto.CartProductsDTO;
import com.cts.products.orderservice.dto.ItemPriceDTO;
import com.cts.products.orderservice.entity.Order;
import com.cts.products.orderservice.entity.OrderProducts;
import com.cts.products.orderservice.repository.OrderRepository;
import com.cts.products.orderservice.servicecom.CartServiceProxy;
import com.cts.products.orderservice.servicecom.PriceServiceProxy;

@Service
public class OrderDomain {

	@Autowired 
	CartServiceProxy cartServiceProxy;
	
	@Autowired 
	PriceServiceProxy priceServiceProxy;
	
	@Autowired
	OrderRepository orderRepository;
	
	public Order addNewOrder(int cartId) {
		Order order = new Order();
		int totalItems = 0;
		
		CartDTO cartDto = cartServiceProxy.getCart(cartId);
		List <OrderProducts> orderProductsList = new ArrayList<>();
		for(CartProductsDTO cartproduct : cartDto.getCartproducts()) {
			OrderProducts orderProducts = new OrderProducts();
			orderProducts.setProductId(cartproduct.getProductId());
			orderProducts.setQuantity(cartproduct.getQuantity());
			ItemPriceDTO itemPriceDto = priceServiceProxy.getProductPrice(cartproduct.getProductId());
			orderProducts.setPricePerItem(itemPriceDto.getPrice());
			orderProducts.setPrice(itemPriceDto.getPrice()*cartproduct.getQuantity());
			order.setTotal(order.getTotal()+orderProducts.getPrice());
			totalItems =totalItems + cartproduct.getQuantity();
			orderProducts.setOrder(order);
			orderProductsList.add(orderProducts);
		}
		order.setOrderproducts(orderProductsList);
		order.setTotalItems(totalItems);
		order.setOrderDate(new Date()); 
		order.setUser(cartDto.getUser());
		Order returnedOrder = orderRepository.save(order);
		return returnedOrder;
	}

	public Order getAnOrder(int orderId) {
		Order order =  orderRepository.findById(orderId).orElse(null);
		return order;
	}
}

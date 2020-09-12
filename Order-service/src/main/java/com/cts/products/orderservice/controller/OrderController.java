package com.cts.products.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.products.orderservice.domain.OrderDomain;
import com.cts.products.orderservice.dto.OrderDTO;
import com.cts.products.orderservice.utils.OrderServiceUtils;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	OrderDomain orderDomain;
	@PostMapping("/order/{cartId}")
	public OrderDTO placeOrder(@PathVariable int cartId) {		
		return OrderServiceUtils.mapOrderToDTO(orderDomain.addNewOrder(cartId));
	}
	
	@GetMapping("/order/{orderId}")
	public OrderDTO getOrder(@PathVariable int orderId) {		
		return OrderServiceUtils.mapOrderToDTO(orderDomain.getAnOrder(orderId));
	}

}

package com.cts.products.orderservice.utils;

import java.util.stream.Collectors;

import com.cts.products.orderservice.dto.OrderDTO;
import com.cts.products.orderservice.dto.OrderProductsDTO;
import com.cts.products.orderservice.entity.Order;

public class OrderServiceUtils {
	
	public static OrderDTO mapOrderToDTO(Order order) {
		if(order==null) return null;
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setUser(order.getUser());
		orderDTO.setId(order.getId());
		orderDTO.setOrderDate(order.getOrderDate());
		orderDTO.setTotal(order.getTotal());
		orderDTO.setTotalItems(order.getTotalItems());
		orderDTO.setOrderproducts(order.getOrderproducts().stream().map(n -> {	
				return new OrderProductsDTO(n.getId(), n.getProductId(), n.getQuantity(), n.getPricePerItem(), 
						n.getPrice(),n.getProductName());}).collect(Collectors.toList()));
		return orderDTO;
	}

}

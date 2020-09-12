package com.cts.products.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.products.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

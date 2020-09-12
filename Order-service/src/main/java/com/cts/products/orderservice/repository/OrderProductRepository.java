package com.cts.products.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.products.orderservice.entity.OrderProducts;

public interface OrderProductRepository extends JpaRepository<OrderProducts, Integer>
{

}

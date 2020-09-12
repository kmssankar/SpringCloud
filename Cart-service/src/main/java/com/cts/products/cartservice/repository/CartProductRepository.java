package com.cts.products.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.products.cartservice.entities.CartProducts;

public interface CartProductRepository extends JpaRepository<CartProducts, Integer>
{

}

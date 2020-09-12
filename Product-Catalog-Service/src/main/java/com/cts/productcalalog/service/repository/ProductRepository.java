package com.cts.productcalalog.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.productcalalog.service.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value = "Select p from Product p where upper(p.name) like %:likeStr%")
	public List<Product> getProductbylikeString(String likeStr);

}

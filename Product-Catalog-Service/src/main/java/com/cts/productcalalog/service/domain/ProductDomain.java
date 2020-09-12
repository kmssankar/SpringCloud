package com.cts.productcalalog.service.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.productcalalog.service.entities.Product;
import com.cts.productcalalog.service.repository.ProductRepository;

@Component
public class ProductDomain {

	@Autowired
	ProductRepository productRepository;

	public boolean addProducts(List<Product> productList) {
		try {
			for (Product product : productList) {
				Product productTosave = new Product(product.getName(), product.getPrice(),product.getDescription());
				productRepository.save(productTosave);
			}
			return true;
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage()+ " === "+ e.toString());
			return false;
		}
	}

	public boolean addProduct(Product product) {
		try {
			Product productTosave = new Product(product.getName(), product.getPrice(),product.getDescription());
			productRepository.save(productTosave);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Product getProduct(int id) {
	
		return	productRepository.findById(id).orElse(null);
	}
	
	public List<Product> getAllProducts(){
		
		return	productRepository.findAll();
	}
	
	public List<Product> getAllProductsbyname(String name){		
		return	productRepository.getProductbylikeString(name);
	}
	
}

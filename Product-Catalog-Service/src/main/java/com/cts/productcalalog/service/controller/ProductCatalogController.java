package com.cts.productcalalog.service.controller;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.productcalalog.service.domain.ProductDomain;
import com.cts.productcalalog.service.dto.ProductList;
import com.cts.productcalalog.service.entities.Product;

@RestController
@RequestMapping("/api")
public class ProductCatalogController {
	@Autowired
	ProductDomain productDomain;

	@PostMapping("/products")
	public String addProducts(@RequestBody ProductList productList) {
		System.out.println("Size " + productList.getProductList().size());
		if (productDomain.addProducts(productList.getProductList())) {
			return "Added successfully";
		} else {
			return "Error occured while adding products";
		}
	}

	@PostMapping("/product")
	public String addProduct(Product product) {
		if (productDomain.addProduct(product)) {
			return "Added successfully";
		} else {
			return "Error occured while adding product";
		}
	}

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int id) {

		return productDomain.getProduct(id);
	}

	@GetMapping("/products")
	public ProductList getProducts() {
		ProductList productList = new ProductList();
		productList.setProductList(productDomain.getAllProducts());
		return productList;
	}
	
	@GetMapping("/products/byName/{name}")
	public ProductList getProductsbyname(@PathVariable String name) {
		ProductList productList = new ProductList();
		productList.setProductList(productDomain.getAllProductsbyname(name));
		return productList;
	}
	
	@GetMapping("/exceptproduct/{id}")
	public Product getExceptProduct(@PathVariable int id) {
		if(id== 2995) {
		throw new RuntimeErrorException(null);
		}
		return productDomain.getProduct(id);
	}
	
}

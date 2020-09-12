package com.cts.productcalalog.service.dto;

import java.util.List;

import com.cts.productcalalog.service.entities.Product;

public class ProductList {
	
	List<Product> productList;

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	

}

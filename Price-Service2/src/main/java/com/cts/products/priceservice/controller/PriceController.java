package com.cts.products.priceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.products.priceservice.domain.PriceServiceDomain;
import com.cts.products.priceservice.dto.ItemPriceDTO;

@RestController
@RequestMapping("/api")
public class PriceController {

	@Autowired 
	PriceServiceDomain priceServiceDomain;
	
	@GetMapping("/product/price/{id}")
	public ItemPriceDTO getPrice(@PathVariable int id) {
		return priceServiceDomain.getpriceforItem(id);
	}
}

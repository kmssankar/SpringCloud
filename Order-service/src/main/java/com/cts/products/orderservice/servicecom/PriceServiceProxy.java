package com.cts.products.orderservice.servicecom;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.products.orderservice.dto.ItemPriceDTO;

@FeignClient(name = "price-service")
@RibbonClient(name ="price-service")
public interface PriceServiceProxy {

	@GetMapping("/api/product/price/{id}")
	ItemPriceDTO getProductPrice(@PathVariable int id);
	
}
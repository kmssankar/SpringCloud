package com.cts.products.cartservice.servicecomm;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.products.cartservice.dto.ProductDTO;

@FeignClient(name = "product-service")
@RibbonClient(name ="product-service")
public interface ProductServiceProxy {
	
	@GetMapping("/api/product/{id}")
	ProductDTO getProduct(@PathVariable int id);

}

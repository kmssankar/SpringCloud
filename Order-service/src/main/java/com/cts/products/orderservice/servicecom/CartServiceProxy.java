package com.cts.products.orderservice.servicecom;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.products.orderservice.dto.CartDTO;

@FeignClient(name = "cart-service")
@RibbonClient(name ="cart-service")
public interface CartServiceProxy {
    
	@GetMapping("/api/cart/{id}")
	CartDTO getCart(@PathVariable int id);
}

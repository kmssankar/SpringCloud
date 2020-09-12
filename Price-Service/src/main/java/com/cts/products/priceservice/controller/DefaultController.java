package com.cts.products.priceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@GetMapping("/default")
	public String getDefaultURL() {
		return "Success";
	}
}

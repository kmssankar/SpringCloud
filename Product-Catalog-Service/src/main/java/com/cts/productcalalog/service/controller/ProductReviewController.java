package com.cts.productcalalog.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.productcalalog.service.domain.ReviewDomain;
import com.cts.productcalalog.service.entities.Review;

@RestController
@RequestMapping("/api")
public class ProductReviewController {

	@Autowired 
	ReviewDomain reviewDomain;
	
	@PostMapping("/review/{id}/product")
	public String addareview(@PathVariable int id,@RequestBody Review review) {	
		return reviewDomain.saveaReview(id, review);
	}
	
	
	@GetMapping("/review/{id}")
	public Review getareview(@PathVariable int id) {		
		return reviewDomain.getaReview(id);
	}
}

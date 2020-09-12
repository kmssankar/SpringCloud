package com.cts.productcalalog.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.productcalalog.service.entities.Product;
import com.cts.productcalalog.service.entities.Review;
import com.cts.productcalalog.service.repository.ProductRepository;
import com.cts.productcalalog.service.repository.ReviewRepository;

@Service
public class ReviewDomain {

	@Autowired 
	ReviewRepository reviewRepository;	
	@Autowired 
	ProductRepository productRepository;
	
	public String saveaReview(int id, Review review) {		
		Product product = productRepository.findById(id).get();
		review.setProduct(product);
		reviewRepository.save(review);
		return "added successfully";
	}
	
	public Review getaReview(int id) {		
		Review review = reviewRepository.findById(id).get();
		return review;
	}
}

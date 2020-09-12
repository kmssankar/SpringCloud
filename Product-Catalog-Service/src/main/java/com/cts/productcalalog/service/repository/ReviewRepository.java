package com.cts.productcalalog.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.productcalalog.service.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}

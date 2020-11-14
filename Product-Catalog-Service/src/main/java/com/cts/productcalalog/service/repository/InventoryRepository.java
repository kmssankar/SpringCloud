package com.cts.productcalalog.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.productcalalog.service.entities.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
	@Query("Select i from Inventory i where i.productId = :productId")
	public Inventory findInventoryByproductId(int productId);

}

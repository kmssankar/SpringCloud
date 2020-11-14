package com.cts.productcalalog.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.productcalalog.service.domain.InventoryDomain;
import com.cts.productcalalog.service.entities.Inventory;

@RestController
public class InventoryController {
	@Autowired
	InventoryDomain inventoryDomain;
	
	@PostMapping("/addInventory")
	public String addInvetory(@RequestBody Inventory inventory) {
		inventoryDomain.addToInventory(inventory);
		return "Added successfully";
	}

    
}

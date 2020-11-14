package com.cts.productcalalog.service.domain;

import java.time.LocalTime;
import java.util.List;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cts.productcalalog.service.dto.OrderDTO;
import com.cts.productcalalog.service.dto.OrderProductsDTO;
import com.cts.productcalalog.service.entities.Inventory;
import com.cts.productcalalog.service.repository.InventoryRepository;

@Service
public class InventoryDomain {

	@Autowired
	InventoryRepository inventoryRepository;

	public String addToInventory(Inventory inventory) {
		try {
			Inventory inv = inventoryRepository.findInventoryByproductId(inventory.getProductId());
			if (inv != null) {
				int currStock = inv.getCurrentStock() + inventory.getCurrentStock();
				inv.setCurrentStock(currStock);
				inv.setMinimumStock(inventory.getMinimumStock());
				inventoryRepository.save(inv);
			} else {
				inventory.setUpdatedTime(LocalTime.now());
				inventoryRepository.save(inventory);
			}

		} catch (DataAccessException e) {
			System.out.println("Exception occured " + e.getMessage());
		}
		return "Updated or added Successfully";
	}
	
	public void updateInventory (OrderDTO orderDto) {
		
		List<OrderProductsDTO> orderList = orderDto.getOrderproducts();
		for(OrderProductsDTO orderPro : orderList) {
			System.out.println(" Message to Reduce Stock " + orderPro.getProductId() + " stock  "+ orderPro.getQuantity());
			reduceStock(orderPro.getProductId(), orderPro.getQuantity());
		}
		
	}
	
	public boolean reduceStock(int id, int stockToReduce ) {
		Inventory inv = inventoryRepository.findInventoryByproductId(id);
		if (inv !=null) {
			int updatedInv = inv.getCurrentStock() - stockToReduce;
			inv.setCurrentStock(updatedInv);
			inventoryRepository.save(inv);
		}
		
		return true;
	}
}

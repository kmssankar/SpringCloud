package com.cts.products.priceservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.products.priceservice.dto.ItemPriceDTO;
import com.cts.products.priceservice.repository.ProductRepository;

@Service
public class PriceServiceDomain {

	@Autowired 
	ProductRepository productRepository;
	
	public ItemPriceDTO getpriceforItem(int itemId) {
		ItemPriceDTO itemPriceDTO = new ItemPriceDTO();
		itemPriceDTO.setPrice(productRepository.findById(itemId).orElseThrow(null).getPrice());
		return itemPriceDTO;
	}
}

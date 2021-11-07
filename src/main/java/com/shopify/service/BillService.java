package com.shopify.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.shopify.entity.BillDetailsEntity;

public interface BillService {

	BillDetailsEntity addProduct(BillDetailsEntity entity);
	
	Optional<BillDetailsEntity> getBill(LocalDate billedDate);
	Optional<BillDetailsEntity> getBill(Long id);
	
	List<BillDetailsEntity> getAllBills(); 
	
}

package com.shopify.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.entity.BillDetailsEntity;
import com.shopify.repository.BillRepository;
import com.shopify.service.BillService;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	private BillRepository billRepository;
	
	
	@Override
	public BillDetailsEntity addProduct(BillDetailsEntity entity) {
		
		return billRepository.save(entity);
	}

	@Override
	public Optional<BillDetailsEntity> getBill(LocalDate billedDate) {
		Optional<BillDetailsEntity> billDetailsEntity =billRepository.findByBilledDate(billedDate);
		return billDetailsEntity;
	}

	@Override
	public List<BillDetailsEntity> getAllBills() {
		List<BillDetailsEntity>  billDetailsEntity = new ArrayList<>();
		billRepository.findAll().forEach(billDetailsEntity::add);
		return billDetailsEntity;
	}

	@Override
	public Optional<BillDetailsEntity> getBill(Long id) {
		Optional<BillDetailsEntity> billDetailsEntity =billRepository.findById(id);
		return billDetailsEntity;
	}

}

package com.shopify.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.entity.BillDetailsEntity;
import com.shopify.service.BillService;

@RestController
public class BillController {

	@Autowired
	private BillService billService;

	@GetMapping("/")
	public String index() {
		return "Hello there! I'm running.";
	}

	@PostMapping("/add")
	public ResponseEntity<BillDetailsEntity> addBill(@RequestBody BillDetailsEntity billDetailsEntity) {
		BillDetailsEntity billDetails = billService.addProduct(billDetailsEntity);
		return new ResponseEntity<BillDetailsEntity>(billDetails, HttpStatus.CREATED);

	}

	@GetMapping("/bills")
	public ResponseEntity<List<BillDetailsEntity>> getAllBills() {
		List<BillDetailsEntity> BillDetailsEntitys = billService.getAllBills();

		if (BillDetailsEntitys.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(BillDetailsEntitys, HttpStatus.OK);

	}

	@GetMapping("bills/{id}")
	public ResponseEntity<BillDetailsEntity> getBillById(@PathVariable("id") Long id) {
		Optional<BillDetailsEntity> billDetailsEntity = billService.getBill(id);

		if (billDetailsEntity.isPresent()) {
			return new ResponseEntity<>(billDetailsEntity.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/bills/due/{billedDate}")
	public ResponseEntity<BillDetailsEntity> getBillByDate(
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yy") LocalDate billedDate) {
		Optional<BillDetailsEntity> billDetailsEntity = billService.getBill(billedDate);
		if (billDetailsEntity.isPresent()) {
			return new ResponseEntity<>(billDetailsEntity.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

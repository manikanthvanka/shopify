package com.shopify.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shopify.constants.Constants;

@Entity
@Table(name=Constants.TB_BILL_DETAILS)
public class BillDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long billNumber;

	@Column(name = "billedTo")
	private String billedTo;

	@Column(name = "billedDate")
	@JsonFormat(pattern="dd-MM-yy")
	LocalDate billedDate;
	
	@Column(name = "billedPrice")
	private Long billedPrice;
	
	@Column(name = "taxOnBill")
	private Long taxOnBill;
	
	@Column(name = "totalPriceAmount")
	private Long totalPriceAmount;

	
	
	public long getBillNumber() {
		return billNumber;
	}



	public void setBillNumber(long billNumber) {
		this.billNumber = billNumber;
	}



	public String getBilledTo() {
		return billedTo;
	}



	public void setBilledTo(String billedTo) {
		this.billedTo = billedTo;
	}



	public LocalDate getBilledDate() {
		return billedDate;
	}



	public void setBilledDate(LocalDate billedDate) {
		this.billedDate = billedDate;
	}



	public Long getBilledPrice() {
		return billedPrice;
	}



	public void setBilledPrice(Long billedPrice) {
		this.billedPrice = billedPrice;
	}



	public Long getTaxOnBill() {
		return taxOnBill;
	}



	public void setTaxOnBill(Long taxOnBill) {
		this.taxOnBill = taxOnBill;
	}



	public Long getTotalPriceAmount() {
		return totalPriceAmount;
	}



	public void setTotalPriceAmount(Long totalPriceAmount) {
		this.totalPriceAmount = totalPriceAmount;
	}



	@Override
	public String toString() {
		return "BillDetailsEntity [billNumber=" + billNumber + ", billedTo=" + billedTo + ", billedDate=" + billedDate
				+ ", billedPrice=" + billedPrice + ", taxOnBill=" + taxOnBill + ", totalPriceAmount=" + totalPriceAmount
				+ "]";
	}



}

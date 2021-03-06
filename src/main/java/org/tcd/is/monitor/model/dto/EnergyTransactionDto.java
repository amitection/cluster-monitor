package org.tcd.is.monitor.model.dto;


public class EnergyTransactionDto {

	private Long iter;
	
	private String timestamp;

	private Long sellerId;
	
	private String buyerName;
	
	private Double price;
	
	private Double amount;
	

	public Long getIter() {
		return iter;
	}

	public void setIter(Long iter) {
		this.iter = iter;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}

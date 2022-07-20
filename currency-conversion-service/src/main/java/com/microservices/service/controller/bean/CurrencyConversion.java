package com.microservices.service.controller.bean;

public class CurrencyConversion {
	private int id;
	 private String from;
	 private String to;
	 private String conversionMultiple;
	 
	private String quantity;
	 private int totalCalculatedAmount;
	 private String environment;
	 public CurrencyConversion() {
		super();
	}
	public CurrencyConversion(int id, String from, String to, String conversionMultiple, String quantity,
				int totalCalculatedAmount, String environment) {
			super();
			this.id = id;
			this.from = from;
			this.to = to;
			this.conversionMultiple = conversionMultiple;
			this.quantity = quantity;
			this.totalCalculatedAmount = totalCalculatedAmount;
			this.environment = environment;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(String conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(int totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
}

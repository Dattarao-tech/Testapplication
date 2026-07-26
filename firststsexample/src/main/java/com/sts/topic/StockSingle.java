package com.sts.topic;

public class StockSingle {
	private String stockName;
	private String singleType;
	private String description;
	public StockSingle(String stockName, String singleType, String description) {
		super();
		this.stockName = stockName;
		this.singleType = singleType;
		this.description = description;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getSingleType() {
		return singleType;
	}
	public void setSingleType(String singleType) {
		this.singleType = singleType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

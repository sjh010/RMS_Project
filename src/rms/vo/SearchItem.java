package rms.vo;

import rms.vo.SearchItem;

public class SearchItem {
	
	private String buildingType;
	private String contractType;
	private int minSize;
	private int maxSize;
	private int minPrice;
	private int maxPrice;
	
	public String getBuildingType() {
		return buildingType;
	}
	public String getContractType() {
		return contractType;
	}
	public int getMinSize() {
		return minSize;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public SearchItem setBuildingType(String buildingType) {
		this.buildingType = buildingType;
		return this;
	}
	public SearchItem setContractType(String contractType) {
		this.contractType = contractType;
		return this;
	}
	public SearchItem setMinSize(int minSize) {
		this.minSize = minSize;
		return this;
	}
	public SearchItem setMaxSize(int maxSize) {
		this.maxSize = maxSize;
		return this;
	}
	public SearchItem setMinPrice(int minPrice) {
		this.minPrice = minPrice;
		return this;
	}
	public SearchItem setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
		return this;
	}
}

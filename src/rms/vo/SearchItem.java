package rms.vo;

public class SearchItem {
	
	private String budingType;
	private String contractType;
	private int minSize;
	private int maxSize;
	private int minPrice;
	private int maxPrice;
	
	public String getBudingType() {
		return budingType;
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
	public void setBudingType(String budingType) {
		this.budingType = budingType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	

}

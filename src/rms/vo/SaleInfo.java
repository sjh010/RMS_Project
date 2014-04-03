package rms.vo;

import java.sql.Date;

public class SaleInfo {

	private Date date;
	private String buildingType;
	private int size;
	private String addr;
	private int price;
	private int deposit;
	private String buildingFeature;
	private String contractType;
	private Customer tenant;
	private Customer host;
	
	public SaleInfo setDate(Date date) {
		this.date = date;
		return this;
	}
	public SaleInfo setBuildingType(String buildingType) {
		this.buildingType = buildingType;
		return this;
	}
	public SaleInfo setSize(int size) {
		this.size = size;
		return this;
	}
	public SaleInfo setAddr(String addr) {
		this.addr = addr;
		return this;
	}
	public SaleInfo setPrice(int price) {
		this.price = price;
		return this;
	}
	public SaleInfo setDeposit(int deposit) {
		this.deposit = deposit;
		return this;
	}
	public SaleInfo setBuildingFeature(String buildingFeature) {
		this.buildingFeature = buildingFeature;
		return this;
	}
	public SaleInfo setContractType(String contractType) {
		this.contractType = contractType;
		return this;
	}
	public SaleInfo setTenant(Customer tenant) {
		this.tenant = tenant;
		return this;
	}
	public SaleInfo setHost(Customer host) {
		this.host = host;
		return this;
	}
	public Date getDate() {
		return date;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public int getSize() {
		return size;
	}
	public String getAddr() {
		return addr;
	}
	public int getPrice() {
		return price;
	}
	public int getDeposit() {
		return deposit;
	}
	public String getBuildingFeature() {
		return buildingFeature;
	}
	public String getContractType() {
		return contractType;
	}
	public Customer getTenant() {
		return tenant;
	}
	public Customer getHost() {
		return host;
	}
	
	
	
}
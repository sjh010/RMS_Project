package rms.dao;

import java.util.List;

import rms.vo.Customer;
import rms.vo.SaleInfo;
import rms.vo.SearchItem;


public interface RmsDAO {
	
	public abstract String registCustomer(Customer customer) throws Exception;
	
	public abstract boolean registSaleInfo(SaleInfo saleInfo) throws Exception;
	
	public abstract List<SaleInfo> getSearchList(SearchItem searchItem) throws Exception;
	
	
}
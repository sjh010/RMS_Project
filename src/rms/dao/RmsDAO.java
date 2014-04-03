package rms.dao;

import rms.vo.Customer;
import rms.vo.SaleInfo;


public interface RmsDAO {
	
	public abstract String registCustomer(Customer customer) throws Exception;
	
	public abstract boolean registSaleInfo(SaleInfo saleInfo) throws Exception;
	
	public abstract void disconnectDB() throws Exception;

	public abstract void connectDB() throws Exception;
	
	// hi~
	

}

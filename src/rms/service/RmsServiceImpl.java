package rms.service;

import rms.dao.RmsDAO;
import rms.dao.RmsDAOImpl;
import rms.vo.Customer;
import rms.vo.SaleInfo;

public class RmsServiceImpl implements RmsService{

	private RmsDAO dao;
	
	public RmsServiceImpl() {
		super();
		this.dao = new RmsDAOImpl();
	}

	@Override
	public boolean inputSaleInfo(SaleInfo saleInfo) {
		
		boolean successFlag = false;
		
		createCustomer(saleInfo.getTenant());
		createCustomer(saleInfo.getHost());
		
		try {
			 successFlag = dao.registSaleInfo(saleInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return successFlag;
	}
	
	private String createCustomer(Customer customer){
		
		try {
			return dao.registCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private boolean createSaleInfo(SaleInfo saleInfo){
		
		try {
			return dao.registSaleInfo(saleInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dao.disconnectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

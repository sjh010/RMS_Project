package rms.service;

import java.util.List;

import rms.dao.RmsDAO;
import rms.dao.RmsDAOInsert;
import rms.dao.RmsDAOSearch;
import rms.vo.Customer;
import rms.vo.SaleInfo;
import rms.vo.SearchItem;

public class RmsServiceImpl implements RmsService{

	private RmsDAO insertDAO;
	private RmsDAO searchDAO;
	
	public RmsServiceImpl() {
		super();
		this.insertDAO = new RmsDAOInsert();
		this.searchDAO = new RmsDAOSearch();
		
	}

	@Override
	public boolean inputSaleInfo(SaleInfo saleInfo) {
		
		boolean successFlag = false;
		
		saleInfo.getTenant().setId(getCustomerId(saleInfo.getTenant()));
		saleInfo.getHost().setId(getCustomerId(saleInfo.getHost()));
		
		try {
			 successFlag = insertDAO.registSaleInfo(saleInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return successFlag;
	}
	
	private String getCustomerId(Customer customer){
		
		try {
			return insertDAO.registCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private boolean createSaleInfo(SaleInfo saleInfo){
		
		try {
			return insertDAO.registSaleInfo(saleInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public List<SaleInfo> inputSearchInfo(SearchItem searchItem) {
		List<SaleInfo> list = null;
		try {
			list = searchDAO.getSearchList(searchItem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


}

package rms.dao;

import java.util.ArrayList;
import java.util.List;

import rms.vo.Customer;
import rms.vo.SaleInfo;
import rms.vo.SearchItem;

public class RmsDAOSearch extends AbstractRmsDAO {
	
	@Override
	public List<SaleInfo> getSearchList(SearchItem searchItem) throws Exception{
		
		connectDB();
		
		String statment = "select info.SALE_INFO_DATE, info.BUILDING_TYPE, " +
						  "info.SALE_INFO_SIZE, info.SALE_INFO_ADDR, info.SALE_INFO_PRICE, " +
						  "info.SALE_INFO_DEPOSIT, info.SALE_INFO_FEATURE, info.CONTRACT_TYPE, " +
						  "c.CUSTOMER_NAME, c.CUSTOMER_TEL, c.CUSTOMER_NAME, c.CUSTOMER_TEL " +
						  "from SALE_INFO info, CUSTOMER c " +
						  "where ";
		
		
		if(searchItem.getBudingType() != null){
			statment = statment + "info.BUILDING_TYPE = " + "'"+searchItem.getBudingType()+"'" + " and ";
		}
		if(searchItem.getContractType() != null){
			statment = statment + "info.CONTRACT_TYPE = " + "'"+searchItem.getContractType()+"'" + " and ";
		}
		if(searchItem.getMaxPrice() != 0){
			statment = statment + "info.SALE_INFO_PRICE between " + searchItem.getMinPrice() + " and " + searchItem.getMaxPrice() + " and ";
		}
		if(searchItem.getMaxSize() != 0){
			statment = statment + "info.SALE_INFO_SIZE between " + searchItem.getMinSize() + " and " + searchItem.getMaxSize() + " and ";
		}
		statment = statment + "1=1 and info.SALE_INFO_HOST = c.CUSTOMER_ID";
		
		System.out.println(statment);
		
		pstmt = con.prepareStatement(statment);
		rs = pstmt.executeQuery();
		
		List<SaleInfo> saleInfoList = new ArrayList<SaleInfo>();
		
		while(rs.next()){
			
			SaleInfo saleInfo = new SaleInfo();
			
			saleInfo.setDate(rs.getDate(1));
			saleInfo.setBuildingType(rs.getString(2));
			saleInfo.setSize(rs.getInt(3));
			saleInfo.setAddr(rs.getString(4));
			saleInfo.setPrice(rs.getInt(5));
			saleInfo.setDeposit(rs.getInt(6));
			saleInfo.setBuildingFeature(rs.getString(7));
			saleInfo.setContractType(rs.getString(8));
			saleInfo.setTenant(new Customer(rs.getString(9), rs.getString(10)));
			saleInfo.setHost(new Customer(rs.getString(11), rs.getString(12)));
			
			saleInfoList.add(saleInfo);
		}
		
		closeRs();
		closePstmt();
		disconnectDB();
		
		return saleInfoList;
		
	}

}


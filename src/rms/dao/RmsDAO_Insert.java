package rms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

import rms.vo.Customer;
import rms.vo.SaleInfo;

public class RmsDAO_Insert extends AbstractRmsDAO {
	
	@Override
	public String registCustomer(Customer customer) throws Exception {
		connectDB();
		String customer_id = searchCustomer(customer);
		if(customer_id == null){
			pstmt = con
					.prepareStatement("insert into "
							+ "customer "
							+ "values('',?,?)");
			
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getPhone());
			pstmt.executeUpdate();
			closePstmt();
	
			customer_id = searchCustomer(customer);
		}
		disconnectDB();		
		return customer_id;
	}

	private String searchCustomer(Customer customer) throws Exception {
		
		String customer_id = null;
		pstmt = con
				.prepareStatement("select customer_id "
						+ "from customer "
						+ "where customer_name = ? and customer_tel = ?");
		pstmt.setString(1, customer.getName());
		pstmt.setString(2, customer.getPhone());
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			customer_id = rs.getString(1);
		}	
		
		closeRs();
		closePstmt();
		
		return customer_id;
	}
	
	
	@Override
	public boolean registSaleInfo(SaleInfo saleInfo) throws Exception {
		connectDB();
		pstmt = con
				.prepareStatement("insert into "
						+ "sale_info "
						+ "values('','',?,?,?,?,?,?,?,?,?)");
		pstmt.setString(1, saleInfo.getContractType());
		pstmt.setString(2, saleInfo.getBuildingType());
		pstmt.setString(3, saleInfo.getAddr());
		pstmt.setInt(4, saleInfo.getSize());
		pstmt.setInt(5, saleInfo.getPrice());
		pstmt.setInt(6, saleInfo.getDeposit());
		pstmt.setString(7, saleInfo.getBuildingFeature());
		pstmt.setString(8, saleInfo.getTenant().getId());
		pstmt.setString(9, saleInfo.getHost().getId());

		pstmt.executeUpdate();
		
		closePstmt();
		disconnectDB();
		
		return true;
	}
	
	
}

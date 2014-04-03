package rms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import rms.vo.Customer;
import rms.vo.SaleInfo;

public class RmsDAOImpl implements RmsDAO {
	Class clz;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private void connectDB() throws Exception {
		clz = Class.forName("oracle.jdbc.OracleDriver");
		try {
			con = DriverManager
					.getConnection("jdbc:oracle:thin:@192.168.0.62:1521:orcl","test","test");
		} catch (Exception e) {
			System.out.println("DB 접속 실패"+e.toString());
			throw e;
		}
	}
	
	private void closePstmt() throws Exception {
		pstmt.close();
		pstmt = null;
	}
	
	private void closeRs() throws Exception {
		rs.close();
		rs = null;
	}
	
	private void disconnectDB() throws Exception {
		try{
			con.close();
			con = null;;
		} catch (Exception e) {throw e;} 
		finally {
			if(rs!=null){try{rs.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			if(con!=null){try{con.close();}catch(Exception e){}}
		}
	}
	
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
		
		closeRs();
		closePstmt();
		disconnectDB();
		
		return true;
	}
}

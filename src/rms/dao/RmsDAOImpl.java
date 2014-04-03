package rms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RmsDAOImpl implements RmsDAO {
	Class clz;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override	
	public void connectDB() throws Exception {
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
		rs.close();
		rs = null;
	}
	
	private void closeRs() throws Exception {
		rs.close();
		rs = null;
	}
	
	@Override
	public void disconnectDB() throws Exception {
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
	public String registBuilding(Building building) throws Exception {
		String building_id = searchBuilding(building);
		if(building_id == null){
			pstmt = con
					.prepareStatement("insert into building values('',?,?,?)");
			pstmt.setString(1, building.getType());
			pstmt.setInt(2, building.getSize());
			pstmt.setString(3, building.getAddr());
	
			pstmt.executeUpdate();
			closePstmt();
			
			building_id = searchBuilding(building);
		}
		return building_id;
	}
	
	private String searchBuilding(Building building) throws Exception {
		String building_id = null;
		pstmt = con
				.prepareStatement("select building_id "
						+ "from building "
						+ "where building_addr = ?");
		pstmt.setString(1, building.getAddr());
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			building_id = rs.getString(1);
		}	
		closeRs();
		closePstmt();
		return building_id;
	}

	@Override
	public String registCustomer(Customer customer) throws Exception {
		String customer_id = searchCustomer(customer);
		if(customer_id == null){
			pstmt = con
					.prepareStatement("insert into "
							+ "customer "
							+ "values('',?,?)");
			
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getPhoneNumber());
			pstmt.executeUpdate();
			closePstmt();
	
			customer_id = searchCustomer(customer);
		}
				
		return customer_id;
	}

	private String searchCustomer(Customer customer) throws Exception {
		String customer_id = null;
		pstmt = con
				.prepareStatement("select customer_id "
						+ "from customer "
						+ "where customer_name = ? and customer_tel = ?");
		pstmt.setString(1, customer.getName());
		pstmt.setString(2, customer.getPhoneNumber());
		
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
		pstmt = con
				.prepareStatement("insert into "
						+ "sale_info "
						+ "values('',?,?,?,?,?,?,?)");
		pstmt.setDate(1, saleInfo.getDate());
		pstmt.setString(2, saleInfo.getBulidingId());
		pstmt.setString(3, saleInfo.getContractType());
		pstmt.setInt(4, saleInfo.getPrice());
		pstmt.setInt(5, saleInfo.getDeposit());
		pstmt.setString(6, saleInfo.getTenantId());
		pstmt.setString(7, saleInfo.getHostId());

		pstmt.executeUpdate();
		
		closeRs();
		closePstmt();
		
		return true;
	}
}

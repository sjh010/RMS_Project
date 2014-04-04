package rms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import rms.vo.Customer;
import rms.vo.SaleInfo;
import rms.vo.SearchItem;

public class AbstractRmsDAO implements RmsDAO {
	
	Class clz;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	protected void connectDB() throws Exception {
		clz = Class.forName("oracle.jdbc.OracleDriver");
		try {
			con = DriverManager
					.getConnection("jdbc:oracle:thin:@192.168.0.62:1521:orcl","test","test");
		} catch (Exception e) {
			System.out.println("DB 접속 실패"+e.toString());
			throw e;
		}
	}
	
	protected void closePstmt() throws Exception {
		pstmt.close();
		pstmt = null;
	}
	
	protected void closeRs() throws Exception {
		rs.close();
		rs = null;
	}
	
	protected void disconnectDB() throws Exception {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registSaleInfo(SaleInfo saleInfo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SaleInfo> getSearchList(SearchItem searchItem) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

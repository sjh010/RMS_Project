package rms.service;

import rms.dao.RmsDAO;
import rms.vo.Customer;
import rms.vo.SaleInfo;

public class RmsServiceImpl implements RmsService{

	private RmsDAO dao;
	
	public RmsServiceImpl() {
		super();
		this.dao = new RmsDAOImpl();
	}

	@Override
	public boolean inputSaleInfo(SaleInfo totalSaleInfo) {
		
		try {
			dao.connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String bulidingId = createBuilding(totalSaleInfo.getBuilding());
		String tenantId = createCustomer(totalSaleInfo.getTenant());
		String hostId = createCustomer(totalSaleInfo.getHost());
		
		SaleInfo saleInfo = new SaleInfo()
							.setDate(totalSaleInfo.getDate())
							.setBulidingId(bulidingId)
							.setContractType(totalSaleInfo.getContactType())
							.setPrice(totalSaleInfo.getPrice())
							.setDeposit(totalSaleInfo.getDeposit())
							.setTenantId(tenantId)
							.setHostId(hostId);
		
		
		
		return createSaleInfo(saleInfo);
		
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

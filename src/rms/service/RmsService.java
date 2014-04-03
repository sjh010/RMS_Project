package rms.service;

import rms.vo.SaleInfo;
import rms.vo.SearchItem;
import java.util.List;

public interface RmsService {

	public abstract boolean inputSaleInfo(SaleInfo saleInfo);
	public abstract List<SaleInfo> inputSearchInfo(SearchItem searchInfo);
	
}
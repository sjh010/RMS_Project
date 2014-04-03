package rms.dao;

import java.util.List;

import rms.vo.SaleInfo;
import rms.vo.SearchItem;



public interface SearchInterface {
	
	public abstract List<SaleInfo> getSearchList(SearchItem searchItem) throws Exception;

}
package service;

import java.util.List;

import entity.CommodityType;

public interface ITypeService {
	
	public CommodityType queryCommodityTypeById(int id);
	
	public boolean addCommodityType(String typeName);
	
	public List<CommodityType> queryCommodityType();
	
	public boolean modifyCommodityType(CommodityType type);
	
}

package dao;

import java.util.List;

import entity.CommodityType;

public interface ITypeDao {
	
	public CommodityType selectCommodityTypeById(int id);
	
	public boolean insertCommodityType(String typeName);

	public List<CommodityType> selectCommodityTypeById();
	
	public boolean updateCommodityType(CommodityType type);
	
}

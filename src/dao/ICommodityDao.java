package dao;

import java.util.List;

import entity.Commodity;

public interface ICommodityDao {
	
	public String creatCommodityId();
	
	public boolean insertCommodity(Commodity com);
	
	public boolean updateCommodity(Commodity com);
	
	public List<Commodity> selectCommodityAll();
	
	public List<Commodity> selectCommodityBycName(String comName);
	
	public Commodity selectCommodityById(String comId);
}

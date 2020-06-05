package service;

import java.util.List;

import entity.Commodity;

public interface ICommodityService {
	
public boolean insertCommodity(Commodity com);
	
	public String creatCommodityId();

	public boolean updateCommodity(Commodity com);
	
	public List<Commodity> selectCommodityAll();
	
	public List<Commodity> selectCommodityBycName(String comName);
	
	public Commodity selectCommodityById(String comId);
}

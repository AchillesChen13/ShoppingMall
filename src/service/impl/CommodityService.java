package service.impl;

import java.util.List;

import dao.ICommodityDao;
import dao.impl.CommodityDao;
import entity.Commodity;
import service.ICommodityService;

public class CommodityService implements ICommodityService{
	ICommodityDao dao = new CommodityDao();

	@Override
	public boolean insertCommodity(Commodity com) {
		// TODO Auto-generated method stub
		return dao.insertCommodity(com);
	}

	@Override
	public boolean updateCommodity(Commodity com) {
		// TODO Auto-generated method stub
		return dao.updateCommodity(com);
	}

	@Override
	public List<Commodity> selectCommodityAll() {
		// TODO Auto-generated method stub
		return dao.selectCommodityAll();
	}

	@Override
	public List<Commodity> selectCommodityBycName(String comName) {
		// TODO Auto-generated method stub
		return dao.selectCommodityBycName(comName);
	}

	@Override
	public Commodity selectCommodityById(String comId) {
		// TODO Auto-generated method stub
		return dao.selectCommodityById(comId);
	}

	@Override
	public String creatCommodityId() {
		// TODO Auto-generated method stub
		return dao.creatCommodityId();
	}

}

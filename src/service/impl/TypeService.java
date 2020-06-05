package service.impl;

import java.util.List;

import dao.ITypeDao;
import dao.impl.TypeDao;
import entity.CommodityType;
import service.ITypeService;

public class TypeService implements ITypeService{
	
	private ITypeDao dao;
	
	public TypeService() {
		dao = new TypeDao();
	}
	

	@Override
	public CommodityType queryCommodityTypeById(int id) {
		// TODO Auto-generated method stub
		return dao.selectCommodityTypeById(id);
	}

	@Override
	public boolean addCommodityType(String typeName) {
		// TODO Auto-generated method stub
		return dao.insertCommodityType(typeName);
	}

	@Override
	public List<CommodityType> queryCommodityType() {
		// TODO Auto-generated method stub
		return dao.selectCommodityTypeById();
	}

	@Override
	public boolean modifyCommodityType(CommodityType type) {
		// TODO Auto-generated method stub
		return dao.updateCommodityType(type);
	}

}

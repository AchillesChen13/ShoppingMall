package model;

import entity.CommodityType;
import service.ITypeService;

public class TypeCommandModify implements TypeCommand{
	
	private ITypeService typeService;
	
	public TypeCommandModify(ITypeService typeService) {
		
		this.typeService = typeService;
	}
	
	@Override
	public void excuteType(CommodityType type) {
		// TODO Auto-generated method stub
		typeService.modifyCommodityType(type);
	}

}

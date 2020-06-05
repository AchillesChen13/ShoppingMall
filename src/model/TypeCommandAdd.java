package model;

import entity.CommodityType;
import service.ITypeService;
import service.impl.TypeService;

public class TypeCommandAdd implements TypeCommand{
	
	private ITypeService typeService;
	
	public TypeCommandAdd(ITypeService typeService) {
		
		this.typeService = typeService;
	}
	
	
	@Override
	public void excuteType(CommodityType type) {
		// TODO Auto-generated method stub
		String typeName = type.getTypeName();
		typeService.addCommodityType(typeName);
	}

}

package model;

import entity.Commodity;
import service.ICommodityService;

public class CommodityCommandAdd implements CommodityCommand{
	
	private ICommodityService commodityService;
	
	public CommodityCommandAdd(ICommodityService commodityService) {
		
		this.commodityService = commodityService;
		System.out.println("CommodityCommandAdd");
	}
	
	
	@Override
	public void excuteType(Commodity comm) {
		// TODO Auto-generated method stub
		System.out.println("CommodityCommandAdd:"+comm);
		commodityService.insertCommodity(comm);
	}

}

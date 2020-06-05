package model;

import entity.Commodity;
import service.ICommodityService;

public class CommodityCommandModify implements CommodityCommand{
	
	private ICommodityService commodityService;
	
	public CommodityCommandModify(ICommodityService commodityService) {
		
		this.commodityService = commodityService;
	}
	
	
	@Override
	public void excuteType(Commodity comm) {
		// TODO Auto-generated method stub
		commodityService.updateCommodity(comm);
	}


}

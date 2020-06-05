package model;

import entity.Commodity;
import service.ICommodityService;

public class BuyTemplate extends AbstractTemplate{
	
	
	
	public BuyTemplate(Commodity com, ICommodityService service, int buyNum) {
		super(com, service, buyNum);
	}

	//ºı…Ÿø‚¥Ê
	@Override
	public void changeStock() {
		// TODO Auto-generated method stub
		Commodity comm = this.getCom();
		ICommodityService service = this.getService();
		int buyNum = this.getBuyNum();
		System.out.println("changeStock£∫"+buyNum);
		comm.setStock(comm.getStock()-buyNum);
		service.updateCommodity(comm);
	}
}

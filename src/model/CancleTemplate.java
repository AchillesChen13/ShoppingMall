package model;

import entity.Commodity;
import service.ICommodityService;

public class CancleTemplate extends AbstractTemplate {
	
	public CancleTemplate(Commodity com, ICommodityService service, int buyNum) {
		super(com, service, buyNum);
		// TODO Auto-generated constructor stub
	}

	//Ôö¼Ó¿â´æ
	@Override
	public void changeStock() {
		// TODO Auto-generated method stub
		Commodity comm = this.getCom();
		ICommodityService service = this.getService();
		int buyNum = this.getBuyNum();
		System.out.println(" CancleTemplate changeStock£º"+buyNum);
		comm.setStock(comm.getStock()+buyNum);
		service.updateCommodity(comm);
	}
	
}

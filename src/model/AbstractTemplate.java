package model;

import entity.Commodity;
import service.ICommodityService;

public abstract class AbstractTemplate {
	
	private Commodity com;
	private ICommodityService service;
	private int buyNum;

	public AbstractTemplate(Commodity com, ICommodityService service, int buyNum) {
		this.com = com;
		this.service = service;
		this.buyNum = buyNum;
	}
	
	public Commodity getCom() {
		return com;
	}

	public void setCom(Commodity com) {
		this.com = com;
	}

	public ICommodityService getService() {
		return service;
	}

	public void setService(ICommodityService service) {
		this.service = service;
	}

	public int getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public final void templateMethod() {
		if (isCancle()) {
			changeStock();
		}
	}
	
	public boolean isCancle() {
		return false;
	}
	
	public abstract void changeStock();
}

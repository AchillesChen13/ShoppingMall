package model;

import service.IPriceService;

public class TemContext {
	
	IPriceService service;
	
	public void setDiscount(IPriceService service) {
		this.service = service;
	}
	
	public double getSumPrice(double price,int buyNum) {
			
		return service.calculatePrice(price, buyNum);
	}
}

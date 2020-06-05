package service.impl;

import service.IPriceService;

public class MemberCashService implements IPriceService{
	
	private double DISCOUNT = 0.9;
	
	@Override
	public double calculatePrice(double price,int buyNum) {
		// TODO Auto-generated method stub
		double rs = price*buyNum*DISCOUNT;
		return rs;
	}

}

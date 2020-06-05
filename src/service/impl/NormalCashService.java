package service.impl;

import service.IPriceService;

public class NormalCashService implements IPriceService{

	@Override
	public double calculatePrice(double price,int buyNum) {
		// TODO Auto-generated method stub
		return price*buyNum;
	}

}

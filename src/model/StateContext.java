package model;

import entity.OrderDB;
import service.IDealStateService;

public class StateContext {
	
	OrderState orderState;
	
	public void setDealState(OrderState orderState) {
		this.orderState = orderState;
	}
	
	public void setOrderState() {
		orderState.setOrderState();
	}
}

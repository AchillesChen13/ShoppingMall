package model;

import entity.OrderDB;
import service.IOrderService;
import service.impl.OrderService;

public class OrderCartState implements OrderState {
	
	
	private IOrderService service = new OrderService();
	private String CARTSTATE = "´ý½áËã";
	
	private OrderDB order;
	
	public OrderCartState(OrderDB order) {
		
		this.order = order;
	}
	
	@Override
	public void setOrderState() {
		// TODO Auto-generated method stub
		order.setStatus(CARTSTATE);
		service.insertOrder(order);
	}

}

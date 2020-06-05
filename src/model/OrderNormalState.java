package model;

import entity.OrderDB;
import service.IOrderService;
import service.impl.OrderService;

public class OrderNormalState implements OrderState{
	
	private IOrderService service = new OrderService();
	private String NORMALSTATE = "´ý´¦Àí";
	private OrderDB order;
	
	

	public OrderNormalState(OrderDB order) {
		
		this.order = order;
	}



	@Override
	public void setOrderState() {
		order.setStatus(NORMALSTATE);
		service.insertOrder(order);
	}
	
}

package model;

import entity.OrderDB;
import service.IOrderService;
import service.impl.OrderService;

public class OrderCancleState implements OrderState {
	
	private IOrderService service = new OrderService();
	private String CANCLESTATE = "ÒÑÈ¡Ïû";
	private OrderDB order;
	
	

	public OrderCancleState(OrderDB order) {
		
		this.order = order;
	}
	@Override
	public void setOrderState() {
		// TODO Auto-generated method stub
		service.updateOrderStateByOid(order.getOrderNo(), CANCLESTATE);
	}

}

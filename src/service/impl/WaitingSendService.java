package service.impl;

import java.util.ArrayList;

import service.IDealStateService;
import service.IOrderService;

public class WaitingSendService implements IDealStateService{
	
	private IDealStateService nextState;
	private IOrderService service = new OrderService();
	private ArrayList<String> orderState;
	private String next = "待收货";
	private int flag = 0;//标记是否被处理
	
	
	public WaitingSendService() {
		orderState = new ArrayList<String>();
//		orderState.add("待处理");
		orderState.add("待配送");
//		orderState.add("待收货");
//		orderState.add("订单已结束");
//		orderState.add("已取消");
	}

	@Override
	public void requestState(int id,String state) {
		if (orderState.contains(state)) {
			service.updateOrderStateByOid(id, next);
//			this.flag=1;
		}
		else {
			if (nextState!=null) {
				nextState.requestState(id, state);
			}
		}
//		return this.flag;
	}

	@Override
	public void setNextState(IDealStateService iStateService) {
		// TODO Auto-generated method stub
		if (this.flag==1) {
			this.nextState = null;
		}
		else {
			this.nextState = iStateService;
		}
	}

}

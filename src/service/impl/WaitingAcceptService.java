package service.impl;

import java.util.ArrayList;

import service.IDealStateService;
import service.IOrderService;

public class WaitingAcceptService implements IDealStateService{
	
	private IDealStateService nextState;
	private IOrderService service = new OrderService();
	private ArrayList<String> orderState;
	private String next = "�����ѽ���";
	private int flag = 0;//����Ƿ񱻴���
	
	
	public WaitingAcceptService() {
		orderState = new ArrayList<String>();
//		orderState.add("������");
//		orderState.add("������");
		orderState.add("���ջ�");
//		orderState.add("�����ѽ���");
//		orderState.add("��ȡ��");
	}

	@Override
	public void requestState(int id,String state) {
		if (orderState.contains(state)) {
			service.updateOrderStateByOid(id, next);
		}
		else {
			if (nextState!=null) {
				nextState.requestState(id, state);
			}
		}
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

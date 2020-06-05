package service.impl;

import java.util.List;

import dao.IOrderDao;
import dao.impl.OrderDao;
import entity.OrderDB;
import service.IOrderService;

public class OrderService implements IOrderService{
	
	private IOrderDao dao = new OrderDao();

	@Override
	public boolean updateOrderStateByOid(int id, String state) {
		// TODO Auto-generated method stub
		return dao.updateOrderStateByOid(id, state);
	}

	@Override
	public boolean insertOrder(OrderDB order) {
		// TODO Auto-generated method stub
		return dao.insertOrder(order);
	}

	@Override
	public List<OrderDB> selectOrderAll() {
		// TODO Auto-generated method stub
		return dao.selectOrderAll();
	}

	@Override
	public List<OrderDB> selectOrderByUid(int uId) {
		// TODO Auto-generated method stub
		return dao.selectOrderByUid(uId);
	}

	
	@Override
	public List<OrderDB> queryOrderByState(int uId,String state) {
		// TODO Auto-generated method stub
		return dao.selectOrderByState(uId,state);
	}

	@Override
	public OrderDB queryOrderByOid(int oId) {
		// TODO Auto-generated method stub
		return dao.selectOrderByOid(oId);
	}

	@Override
	public List<OrderDB> queryOrderByState(String state) {
		// TODO Auto-generated method stub
		return dao.selectOrderByState(state);
	}

}

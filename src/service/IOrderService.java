package service;

import java.util.List;

import entity.OrderDB;

public interface IOrderService {
	
	public boolean updateOrderStateByOid(int id,String state);
	
	public boolean insertOrder(OrderDB order);
	
	public List<OrderDB> selectOrderAll();
	
	public List<OrderDB> selectOrderByUid(int uId);
	
	public List<OrderDB> queryOrderByState(int uId,String state);
	
	public OrderDB queryOrderByOid(int oId);
	
	public List<OrderDB> queryOrderByState(String state);
}

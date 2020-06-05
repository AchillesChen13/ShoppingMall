package dao;

import java.util.List;

import entity.OrderDB;

public interface IOrderDao {
	
	public boolean updateOrderStateByOid(int id,String state);
	
	public boolean insertOrder(OrderDB order);
	
	public List<OrderDB> selectOrderAll();
	
	public List<OrderDB> selectOrderByUid(int uId);

	public List<OrderDB> selectOrderByState(int uId,String state);

	public OrderDB selectOrderByOid(int oId);

	public List<OrderDB> selectOrderByState(String state);
	
}

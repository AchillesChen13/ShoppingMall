package dao;

import java.util.List;

import entity.CartDetail;

public interface ICartDao {
	
	public boolean deleteCommodityFromCart(CartDetail detail);
	
	public boolean insertCommodityInCart(CartDetail detail);
	
	public List<CartDetail> selectCartByUid(int uId);
	
}

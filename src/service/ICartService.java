package service;

import java.util.List;

import entity.CartDetail;

public interface ICartService {
	
	public boolean removeCommodityFromCart(CartDetail detail);
	
	public boolean addCommodityInCart(CartDetail detail);
	
	public List<CartDetail> queryCartByUid(int uId);
	
}

package service.impl;

import java.util.List;

import dao.ICartDao;
import dao.impl.CartDao;
import entity.CartDetail;
import service.ICartService;

public class CartService implements ICartService {
	
	private ICartDao dao = new CartDao();
	
	@Override
	public boolean removeCommodityFromCart(CartDetail detail) {
		// TODO Auto-generated method stub
		return dao.deleteCommodityFromCart(detail);
	}

	@Override
	public boolean addCommodityInCart(CartDetail detail) {
		// TODO Auto-generated method stub
		return dao.insertCommodityInCart(detail);
	}

	@Override
	public List<CartDetail> queryCartByUid(int uId) {
		// TODO Auto-generated method stub
		return dao.selectCartByUid(uId);
	}

}

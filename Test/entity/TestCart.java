package entity;

import org.junit.Test;

import dao.ICartDao;
import dao.impl.CartDao;
import junit.framework.Assert;

public class TestCart {
	
	@Test
	public void testCartMethod() {
		CartDetail cart1 = new CartDetail();
		cart1.setBuyNum(5);
		cart1.setCommodityNo("C0000001");
		cart1.setUserId(1);
		CartDetail cart3 = new CartDetail();
		cart3.setBuyNum(5);
		cart3.setCommodityNo("C0000001");
		cart3.setUserId(1);
		CartDetail cart2 = new CartDetail();
		cart2.setBuyNum(3);
		cart2.setCommodityNo("C0000002");
		cart2.setUserId(1);
		
		ICartDao dao = new CartDao();
		CartDetail detail = new CartDetail();
		detail.setCommodityNo("C0000001");
		detail.setUserId(1);

		//Assert.assertEquals(true, dao.insertCommodityInCart(cart2));
		System.out.println(dao.selectCartByUid(1));
//		System.out.println(dao.deleteCommodityFromCart(detail));
	}
}

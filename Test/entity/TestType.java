package entity;

import org.junit.Test;
import dao.ITypeDao;
import dao.impl.TypeDao;

public class TestType {
	@Test
	public void testAddType() {
		ITypeDao dao = new TypeDao();
//		boolean rs = dao.insertCommodityType("ˮ��");
//		Assert.assertEquals(true, rs);
		System.out.println(dao.selectCommodityTypeById(2));
	}
}

package entity;

import org.junit.Test;

import dao.ISupDao;
import dao.impl.SupDao;
import junit.framework.Assert;

public class TestSupDao {
	@Test
	public void testSupLogin() {
		Supermarket sup = new Supermarket(1,"admin","123456","15684168890");
		ISupDao supDao = new SupDao();
		supDao.supLogin(sup);
		Assert.assertEquals(true, supDao.supLogin(sup));
	}
}

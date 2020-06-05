package entity;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.IAddressDao;
import dao.impl.AddressDao;

public class TestAddress {
	
	
	@Test
	public void testAMethod() {
		IAddressDao dao = new AddressDao();
		Address address = new Address();
		address.setAddress("111111111");
		address.setIsDefault(1);
		address.setName("cje");
		address.setPhone("12123456");
		address.setUserId(1);
		address.setAddressNo(1);
//		Assert.assertEquals(true, dao.insertAddress(address));
//		Assert.assertEquals(1, dao.selectAddressByUId(1));
		System.out.println(dao.selectAddressByUserId(1));
		List<Address> ladd = dao.sortByDefaultId(dao.selectAddressByUserId(1));
		System.out.println(ladd);
//		Assert.assertEquals(true, dao.updateAddress(address));
//		Assert.assertEquals(true, dao.deleteAddressById(1));
//		System.out.println(dao.selectAddressById(2));
//		System.out.println(dao.selectAddressByDefalutId(1,1));
	}
}

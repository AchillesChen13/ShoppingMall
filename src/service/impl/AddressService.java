package service.impl;

import java.util.List;

import dao.IAddressDao;
import dao.impl.AddressDao;
import entity.Address;
import service.IAddressService;

public class AddressService implements IAddressService {
	
	private IAddressDao dao = new AddressDao();

	@Override
	public List<Address> selectAddressByUserId(int id) {
		// TODO Auto-generated method stub
		return dao.selectAddressByUserId(id);
	}

	@Override
	public boolean insertAddress(Address address) {
		// TODO Auto-generated method stub
		return dao.insertAddress(address);
	}

	@Override
	public boolean deleteAddressById(int aId) {
		// TODO Auto-generated method stub
		return dao.deleteAddressById(aId);
	}

	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		return dao.updateAddress(address);
	}

	@Override
	public Address selectAddressById(int id) {
		// TODO Auto-generated method stub
		return dao.selectAddressById(id);
	}

	@Override
	public Address selectAddressByDefalutId(int uId, int DefalutId) {
		// TODO Auto-generated method stub
		return dao.selectAddressByDefalutId(uId, DefalutId);
	}

}

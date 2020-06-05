package dao;

import java.util.List;

import entity.Address;

public interface IAddressDao {
	
	public List<Address> selectAddressByUserId(int id);
	
	public boolean insertAddress(Address address);
	
	public boolean deleteAddressById(int aId);
	
	public boolean updateAddress(Address address);
	
	public Address selectAddressById(int id);
	
	public Address selectAddressByDefalutId(int uId,int DefalutId);
	
	public List<Address> sortByDefaultId(List<Address> addresslist);
	
//	public int selectAddressByUId(int uId);
}

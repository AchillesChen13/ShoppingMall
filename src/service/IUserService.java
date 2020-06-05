package service;

import entity.User;

public interface IUserService {
	
	public int queryUserByPhone(String phone);
	
	public boolean userRegiste(User user);
	
	public boolean userLogin(User user);
	
	public User queryUserById(int uId);
}

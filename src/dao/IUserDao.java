package dao;

import entity.User;

public interface IUserDao {
	
	public int queryUserByPhone(String uId);
	
	public boolean userRegiste(User user);
	
	public boolean userLogin(User user);

	public User selectUserById(int uId);
	
}

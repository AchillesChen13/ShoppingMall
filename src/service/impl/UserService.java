package service.impl;

import dao.IUserDao;
import dao.impl.UserDao;
import entity.User;
import service.IUserService;

public class UserService implements IUserService{
	
	
	IUserDao dao = new UserDao();

	@Override
	public int queryUserByPhone(String uId) {
		// TODO Auto-generated method stub
		return dao.queryUserByPhone(uId);
	}

	@Override
	public boolean userRegiste(User user) {
		// TODO Auto-generated method stub
		return dao.userRegiste(user);
	}

	@Override
	public boolean userLogin(User user) {
		// TODO Auto-generated method stub
		return dao.userLogin(user);
	}

	@Override
	public User queryUserById(int uId) {
		// TODO Auto-generated method stub
		return dao.selectUserById(uId);
	}

}

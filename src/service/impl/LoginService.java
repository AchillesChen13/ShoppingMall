package service.impl;

import service.IUserService;
import service.IUserState;

public class LoginService implements IUserState {
	
	IUserService service =new UserService();
	
	@Override
	public int loginState() {
		// TODO Auto-generated method stub
		return 1;
	}

}

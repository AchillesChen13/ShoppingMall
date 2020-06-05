package entity;

import service.IUserState;

public class UserState {
	IUserState state;

	public void setUserState(IUserState state) {
		this.state = state;
	}
	
	public int getUserState() {
		if (state!=null) {
			return state.loginState();
		}
		else {
			return -1;
		}
	}
	
}

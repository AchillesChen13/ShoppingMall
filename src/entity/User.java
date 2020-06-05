package entity;

public class User {
	private int userId;//�û��˺�
	private int menmber;//�Ƿ��Ա
	private String userName;//�û�����
	private String password;//�û�����
	private String userPhone;//�û��绰
	
	
	
	public User(int userId, int menmber, String userName, String password, String userPhone) {
		this.userId = userId;
		this.menmber = menmber;
		this.userName = userName;
		this.password = password;
		this.userPhone = userPhone;
	}

	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getMenmber() {
		return menmber;
	}

	public void setMenmber(int menmber) {
		this.menmber = menmber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String toString(){
		return String.format("%s,%s,%s,%s",userId,userName,password,userPhone);
	}
	
}

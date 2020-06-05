package entity;

public class Supermarket {
	private int supId;//超市账号
	private String supName;//超市名称
	private String supPassword;//超市密码
	private String supPhone;//超市电话
	public Supermarket(int supId,String supName,String supPassword,String supPhone) {
		this.supId = supId;
		this.supName = supName;
		this.supPassword = supPassword;
		this.supPhone = supPhone;
	}
	public  Supermarket() {
		
	}
	
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getSupPassword() {
		return supPassword;
	}
	public void setSupPassword(String supPassword) {
		this.supPassword = supPassword;
	}
	public String getSupPhone() {
		return supPhone;
	}
	public void setSupPhone(String supPhone) {
		this.supPhone = supPhone;
	}
	public String toString() {
		return String.format("%s,%s",supId,supPassword);
	}
}

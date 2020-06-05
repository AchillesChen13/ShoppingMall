package entity;

public class Address {
	private int addressNo;//地址编号
	private int userId;
	private String name;//姓名
	private String phone;//电话
	private String address;//地址
	private int IsDefault;//是否默认地址

	public Address() {
		
	}

	public Address(int addressNo, int userId, String name, String phone, String address, int isDefault) {
		this.addressNo = addressNo;
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		IsDefault = isDefault;
	}

	public int getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsDefault() {
		return IsDefault;
	}

	public void setIsDefault(int isDefault) {
		IsDefault = isDefault;
	}

	public String toString(){
		return String.format("%s,%d,%s,%s,%s,%d",addressNo,userId,name,address,phone,IsDefault);
	}
}

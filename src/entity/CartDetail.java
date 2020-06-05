package entity;

public class CartDetail {
	
	private int cartNo;
	private String commodityNo;
	private int buyNum;
	private int userId;
	
	
	public CartDetail() {
		
	}

	public CartDetail(int cartNo, String commodityNo, int buyNum, int userId) {
		this.cartNo = cartNo;
		this.commodityNo = commodityNo;
		this.buyNum = buyNum;
		this.userId = userId;
	}

	public String getCommodityNo() {
		return commodityNo;
	}

	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}

	public int getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	
	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "commodityNo=" + commodityNo + ", buyNum=" + buyNum;
	}
	
}

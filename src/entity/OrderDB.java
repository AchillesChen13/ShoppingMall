package entity;

import java.sql.Date;

public class OrderDB {
	private int orderNo;// 订单编号
	private String status;// 订单状态
	private double sumPrice;// 总价
	private String recipeName;// 收件人姓名
	private String recipePhone;// 收件人电话
	private String recipeAddre;// 收件人地址
	private String orderTime;// 下单时间
	private String goodsName;// 物品名称
	private double num;// 购买数量
	private int userId;//用户编号
	private String commodityNo;//商品编号
	
	
	public OrderDB() {
		
	}

	

	



	public OrderDB(int orderNo, String status, double sumPrice, String recipeName, String recipePhone,
			String recipeAddre, String orderTime, String goodsName, double num, int userId, String commodityNo) {
		super();
		this.orderNo = orderNo;
		this.status = status;
		this.sumPrice = sumPrice;
		this.recipeName = recipeName;
		this.recipePhone = recipePhone;
		this.recipeAddre = recipeAddre;
		this.orderTime = orderTime;
		this.goodsName = goodsName;
		this.num = num;
		this.userId = userId;
		this.commodityNo = commodityNo;
	}







	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipePhone() {
		return recipePhone;
	}

	public void setRecipePhone(String recipePhone) {
		this.recipePhone = recipePhone;
	}

	public String getRecipeAddre() {
		return recipeAddre;
	}

	public void setRecipeAddre(String recipeAddre) {
		this.recipeAddre = recipeAddre;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}
	
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public String getCommodityNo() {
		return commodityNo;
	}







	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}







	public String toString() {
		return String.format("%s,%s,%s,%.2f,%.2f,%s,%s,%s,%s,%d", orderNo, status, goodsName, num, sumPrice, recipeName,
				recipePhone, recipeAddre, orderTime,userId);
	}
}

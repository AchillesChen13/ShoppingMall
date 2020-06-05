package entity;

import java.sql.Date;

public class OrderDB {
	private int orderNo;// �������
	private String status;// ����״̬
	private double sumPrice;// �ܼ�
	private String recipeName;// �ռ�������
	private String recipePhone;// �ռ��˵绰
	private String recipeAddre;// �ռ��˵�ַ
	private String orderTime;// �µ�ʱ��
	private String goodsName;// ��Ʒ����
	private double num;// ��������
	private int userId;//�û����
	private String commodityNo;//��Ʒ���
	
	
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

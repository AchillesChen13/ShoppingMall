package entity;

import java.sql.Date;

public class Commodity {
	private String commodityNo;
	private String commodityName;// 商品名称
	private double price;// 单价
	private String unit;// 单位
	private double stock;// 库存
	private Date produceDate;// 生产日期
	private int qualityDate;// 保质期
	private String content;// 商品描述
	private String typeName;//商品类型
	private String imgUri;//商品图片地址

	public Commodity(String commodityNo,String typeName,String commodityName, double price, String unit, double stock,
			Date producedate, int qualityDate,String content,String imgUri) {
		this.commodityNo = commodityNo;
		this.commodityName = commodityName;
		this.typeName = typeName;
		this.price = price;
		this.unit = unit;
		this.stock = stock;
		this.produceDate = producedate;
		this.qualityDate = qualityDate;
		this.content = content;
		this.imgUri = imgUri;
	}

	public Commodity() {

	}

	public String getCommodityNo() {
		return commodityNo;
	}

	public void setCommodityNo(String commodityNo) {
		this.commodityNo = commodityNo;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}

	public int getQualityDate() {
		return qualityDate;
	}

	public void setQualityDate(int qualityDate) {
		this.qualityDate = qualityDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getCommodityNo().hashCode()+this.getCommodityName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
		{
			return true;
		}
		if(obj instanceof Commodity)
		{
			Commodity i = (Commodity)obj;
			if(this.getCommodityNo().equals(i.getCommodityNo())&&this.getCommodityName().equals(i.getCommodityName()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public String toString() {
		return String.format("%s,%s,%s,%.2f,%s,%.2f,%s,%d,%s,%s",commodityNo,typeName, commodityName, price, unit, stock, produceDate, qualityDate,
				content,imgUri);
	}
}

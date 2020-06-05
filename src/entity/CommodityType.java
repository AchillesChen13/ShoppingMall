package entity;

public class CommodityType {
	
	private int typeNo;//��Ʒ����
	private String typeName;//��������
	
	public CommodityType (int typeNo,String typeName) {
		this.typeNo = typeNo;
		this.typeName = typeName;
	}
	public CommodityType() {
		
	}
	public int getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String toString() {
		return String.format("%s,%s",typeNo, typeName);
	}
}

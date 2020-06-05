package entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//���ﳵ��
public class CartTest {

	//������Ʒ�ļ���
	private HashMap<OrderDB,Integer> goods;
	
	//���ﳵ���ܽ��
	private double totalPrice;

	//���췽��
	public CartTest()
	{
		goods = new HashMap<OrderDB,Integer>();
		totalPrice = 0.0;
	}
	
	
	public HashMap<OrderDB, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<OrderDB, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//�����Ʒ�����ﳵ�ķ���
	public boolean addGoodsInCart(OrderDB item ,int number)
	{
		if(goods.containsKey(item))
		{
			goods.put(item, goods.get(item)+number);
		}
		else
		{
			goods.put(item, number);	
		}
		calTotalPrice(); //���¼��㹺�ﳵ���ܽ��
		return true;
	}
	
	//ɾ����Ʒ�ķ���
	public boolean removeGoodsFromCart(OrderDB item)
	{
		goods.remove(item);
		calTotalPrice(); //���¼��㹺�ﳵ���ܽ��
		return true;
	}
	
	//ͳ�ƹ��ﳵ���ܽ��
	public double calTotalPrice()
	{
		double sum = 0.0;
		Set<OrderDB> keys = goods.keySet(); //��ü��ļ���
		Iterator<OrderDB> it = keys.iterator(); //��õ���������
	    while(it.hasNext())
	    {
	    	OrderDB i = it.next();
	    	sum += i.getSumPrice();
	    }
	    this.setTotalPrice(sum); //���ù��ﳵ���ܽ��
	    return this.getTotalPrice();
	}
	
	public static void main(String[] args) {
		
		//�ȴ���������Ʒ����
//		Commodity i1 = new Commodity(1,"��������Ь","����",200,500,"001.jpg");
//		Items i2 = new Items(2,"�����˶�Ь","����",300,500,"002.jpg");
//		Items i3 = new Items(1,"��������Ь","����",200,500,"001.jpg");
		java.sql.Date date =new java.sql.Date(new Date().getTime());
		Commodity c1 =new Commodity("C0000001","ˮ��","�㽶",4.5,"Ԫ/��",100,date,10,"dsadsa"," ");
		Commodity c2 =new Commodity("C0000001","ˮ��","�㽶",4.5,"Ԫ/��",100,date,10,"dsadsa"," ");
		Commodity c3 =new Commodity("C0000002","ˮ��","ƻ��",4.5,"Ԫ/��",100,date,10,"dsadsa"," ");
		
		
		OrderDB order1 = new OrderDB();
		order1.setOrderNo(1);
		order1.setGoodsName("�㽶");
		order1.setNum(10);
		order1.setSumPrice(300);
		
		OrderDB order2 = new OrderDB();
		order2.setOrderNo(2);
		order2.setGoodsName("�㽶");
		order2.setNum(10);
		order2.setSumPrice(300);
		
		OrderDB order3 = new OrderDB();
		order3.setOrderNo(1);
		order3.setGoodsName("�㽶");
		order3.setNum(10);
		order3.setSumPrice(200);
		
		CartTest c = new CartTest();
		c.addGoodsInCart(order1, 10);
		c.addGoodsInCart(order2, 10);
		c.addGoodsInCart(order3, 10);
		//�ٴι�����������Ь������3˫
//		c.addGoodsInCart(c3, 3);
		c.removeGoodsFromCart(order3);
		
		
		//����������Ʒ�ļ���
		Set<Map.Entry<OrderDB, Integer>> items= c.getGoods().entrySet();
		for(Map.Entry<OrderDB, Integer> obj:items)
		{
			System.out.println(obj);
		}
		
		
		System.out.println("���ﳵ���ܽ�"+c.getTotalPrice());
		
	}
	
}

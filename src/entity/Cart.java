package entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//���ﳵ��
public class Cart {

	//������Ʒ�ļ���
	private HashMap<Commodity,Integer> goods;
	
	//���ﳵ���ܽ��
	private double totalPrice;

	//���췽��
	public Cart()
	{
		goods = new HashMap<Commodity,Integer>();
		totalPrice = 0.0;
	}
	
	
	public HashMap<Commodity, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Commodity, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//�����Ʒ�����ﳵ�ķ���
	public boolean addGoodsInCart(Commodity item ,int number)
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
	public boolean removeGoodsFromCart(Commodity item)
	{
		goods.remove(item);
		calTotalPrice(); //���¼��㹺�ﳵ���ܽ��
		return true;
	}
	
	//ͳ�ƹ��ﳵ���ܽ��
	public double calTotalPrice()
	{
		double sum = 0.0;
		Set<Commodity> keys = goods.keySet(); //��ü��ļ���
		Iterator<Commodity> it = keys.iterator(); //��õ���������
	    while(it.hasNext())
	    {
	    	Commodity i = it.next();
	    	sum += i.getPrice()* goods.get(i);
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

		Cart c = new Cart();
		c.addGoodsInCart(c1, 1);
		c.addGoodsInCart(c3, 2);
		//�ٴι�����������Ь������3˫
//		c.addGoodsInCart(c3, 3);
		
		
		
		//����������Ʒ�ļ���
		Set<Map.Entry<Commodity, Integer>> items= c.getGoods().entrySet();
		for(Map.Entry<Commodity, Integer> obj:items)
		{
			System.out.println(obj.getKey().getCommodityName());
			System.out.println(obj.getValue());
			System.out.println(obj);
		}
		
		System.out.println("����");
		System.out.println(c.getGoods().keySet().iterator().next().getCommodityName());
		
		System.out.println("���ﳵ���ܽ�"+c.getTotalPrice());
		
	}
	
}

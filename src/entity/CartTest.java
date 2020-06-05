package entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//购物车类
public class CartTest {

	//购买商品的集合
	private HashMap<OrderDB,Integer> goods;
	
	//购物车的总金额
	private double totalPrice;

	//构造方法
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
	
	//添加商品进购物车的方法
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
		calTotalPrice(); //重新计算购物车的总金额
		return true;
	}
	
	//删除商品的方法
	public boolean removeGoodsFromCart(OrderDB item)
	{
		goods.remove(item);
		calTotalPrice(); //重新计算购物车的总金额
		return true;
	}
	
	//统计购物车的总金额
	public double calTotalPrice()
	{
		double sum = 0.0;
		Set<OrderDB> keys = goods.keySet(); //获得键的集合
		Iterator<OrderDB> it = keys.iterator(); //获得迭代器对象
	    while(it.hasNext())
	    {
	    	OrderDB i = it.next();
	    	sum += i.getSumPrice();
	    }
	    this.setTotalPrice(sum); //设置购物车的总金额
	    return this.getTotalPrice();
	}
	
	public static void main(String[] args) {
		
		//先创建两个商品对象
//		Commodity i1 = new Commodity(1,"沃特篮球鞋","温州",200,500,"001.jpg");
//		Items i2 = new Items(2,"李宁运动鞋","广州",300,500,"002.jpg");
//		Items i3 = new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");
		java.sql.Date date =new java.sql.Date(new Date().getTime());
		Commodity c1 =new Commodity("C0000001","水果","香蕉",4.5,"元/斤",100,date,10,"dsadsa"," ");
		Commodity c2 =new Commodity("C0000001","水果","香蕉",4.5,"元/斤",100,date,10,"dsadsa"," ");
		Commodity c3 =new Commodity("C0000002","水果","苹果",4.5,"元/斤",100,date,10,"dsadsa"," ");
		
		
		OrderDB order1 = new OrderDB();
		order1.setOrderNo(1);
		order1.setGoodsName("香蕉");
		order1.setNum(10);
		order1.setSumPrice(300);
		
		OrderDB order2 = new OrderDB();
		order2.setOrderNo(2);
		order2.setGoodsName("香蕉");
		order2.setNum(10);
		order2.setSumPrice(300);
		
		OrderDB order3 = new OrderDB();
		order3.setOrderNo(1);
		order3.setGoodsName("香蕉");
		order3.setNum(10);
		order3.setSumPrice(200);
		
		CartTest c = new CartTest();
		c.addGoodsInCart(order1, 10);
		c.addGoodsInCart(order2, 10);
		c.addGoodsInCart(order3, 10);
		//再次购买沃特篮球鞋，购买3双
//		c.addGoodsInCart(c3, 3);
		c.removeGoodsFromCart(order3);
		
		
		//变量购物商品的集合
		Set<Map.Entry<OrderDB, Integer>> items= c.getGoods().entrySet();
		for(Map.Entry<OrderDB, Integer> obj:items)
		{
			System.out.println(obj);
		}
		
		
		System.out.println("购物车的总金额："+c.getTotalPrice());
		
	}
	
}

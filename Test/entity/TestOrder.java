package entity;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.junit.Assert;
import org.junit.Test;
import dao.IOrderDao;
import dao.impl.OrderDao;

public class TestOrder {
	
	@Test
	public void testOrderMethod() {
		IOrderDao dao = new OrderDao();
		
		OrderDB order = new OrderDB();
		order.setGoodsName("香蕉");
		order.setNum(10);
		
//		Assert.assertEquals(true, dao.insertOrder(order));
		
//		Assert.assertEquals(true, dao.updateOrderStateByOid( 1, "已完成"));
//		System.out.println(dao.selectOrderByUid(1));
		System.out.println(dao.selectOrderByState(1, "待处理").size());
	}
}

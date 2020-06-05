package dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.IOrderDao;
import db.MyHibernateSessionFactory;
import entity.OrderDB;

public class OrderDao implements IOrderDao{

	@Override
	public boolean updateOrderStateByOid(int oid,String state) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
//		OrderDB oderdb = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			
			hql = "update OrderDB set status = '"+state+"' where orderNo ="+oid;
			Query query = session.createQuery(hql);
			int rs = -1;
			rs = query.executeUpdate();
			System.out.println(rs);
			tx.commit();//�ύ����
			if (rs>0) {
				return true;
			}
			else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public boolean insertOrder(OrderDB order) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			//�����µ�ʱ��
			java.sql.Date now = new java.sql.Date(new Date().getTime());
			String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(now);
			order.setOrderTime(date);
			
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(order);
			tx.commit();//�ύ����
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public List<OrderDB> selectOrderAll() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<OrderDB> oList = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from OrderDB";
			Query query = session.createQuery(hql);
			oList = query.list();
			tx.commit();//�ύ����
			return oList;
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return oList;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public List<OrderDB> selectOrderByUid(int uId) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<OrderDB> orderList = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from OrderDB where userId="+uId;
			Query query = session.createQuery(hql);
			orderList = query.list();
			tx.commit();
			return orderList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return orderList;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	
	@Override
	public List<OrderDB> selectOrderByState(int uId,String state) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<OrderDB> orderList = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from OrderDB where userId="+uId+"and status='"+state+"'";
			Query query = session.createQuery(hql);
			orderList = query.list();
			tx.commit();
			return orderList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return orderList;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	
	@Override
	public OrderDB selectOrderByOid(int oId) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		OrderDB orderDB = null;
		
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			orderDB = (OrderDB)session.get(OrderDB.class, oId);
			tx.commit();//�ύ����
			return orderDB;
		}catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return orderDB;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public List<OrderDB> selectOrderByState(String state) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<OrderDB> orderList = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from OrderDB where status='"+state+"'";
			Query query = session.createQuery(hql);
			orderList = query.list();
			tx.commit();
			return orderList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return orderList;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

}

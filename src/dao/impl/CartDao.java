package dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ICartDao;
import db.MyHibernateSessionFactory;
import entity.CartDetail;

public class CartDao implements ICartDao{

	@Override
	public boolean deleteCommodityFromCart(CartDetail detail) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from CartDetail where commodityNo='"+detail.getCommodityNo()+"' and userId="+detail.getUserId();
			Query query = session.createQuery(hql);
			List<CartDetail> details = query.list();
			for (CartDetail cartDetail : details) {
				session.delete(cartDetail);
			}
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean insertCommodityInCart(CartDetail detail) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(detail);
			tx.commit();//提交事务
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
	public List<CartDetail> selectCartByUid(int uId) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<CartDetail> details = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from CartDetail where userId="+uId;
			Query query = session.createQuery(hql);
			details = query.list();
			tx.commit();
			return details;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return details;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

}

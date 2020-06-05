package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ISupDao;
import db.MyHibernateSessionFactory;
import entity.Supermarket;

public class SupDao implements ISupDao{

	public boolean supLogin(Supermarket sup) {
		//事务对象
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Supermarket where supName=? and supPassword=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, sup.getSupName());
			query.setParameter(1, sup.getSupPassword());
			List list = query.list();
			tx.commit();//提交事务
			if (list.size()>0) {
				return true;
			}
			else {
				return false;
			}
			
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
	
}

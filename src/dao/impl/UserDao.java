package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.IUserDao;
import db.MyHibernateSessionFactory;
import entity.User;

public class UserDao implements IUserDao {
	
	@Override
	public int queryUserByPhone(String phone) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		int rs = -1;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from User where userPhone=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, phone);
			List<User> list =  query.list();
			tx.commit();//提交事务
			if (list.size()!=0) {
				rs = list.get(0).getUserId();
			}
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return rs;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public boolean userRegiste(User user) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(user);
			System.out.println(1);
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
	public boolean userLogin(User user) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from User where userPhone=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUserPhone());
			query.setParameter(1, user.getPassword());
			List list = query.list();
			System.out.println(list.size());
			tx.commit();//提交事务
			if (list.size()>0) {
				System.out.println(true);
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

	@Override
	public User selectUserById(int uId) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		User user = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			user = (User)session.get(User.class,uId);
			tx.commit();//提交事务
			return user;
		}catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}
}

package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ICommodityDao;
import db.MyHibernateSessionFactory;
import entity.Commodity;

public class CommodityDao implements ICommodityDao{
	
	@Override
	public String creatCommodityId() {
		
		Transaction tx = null;
		String hql = "";
		String cId;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			
			//获得当前商品的最大编号
			hql = "select max(commodityNo) from Commodity";
			Query query = session.createQuery(hql);
			
			cId = (String)query.uniqueResult();
			tx.commit();//提交事务
			if (cId==null||"".equals(cId)) {
				cId = "C0000001";
			}
			else {
				String tId = cId.substring(1);
				int id = Integer.parseInt(tId);
				id++;
				
				tId = String.valueOf(id);
				int len = tId.length();
				for (int i=0;i<7-len;i++) {
					tId = "0"+tId;
				}
				cId = "C"+tId;
			}
			return cId;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public boolean insertCommodity(Commodity com) {
		// TODO Auto-generated method stub
		
		com.setCommodityNo(creatCommodityId());
		Transaction tx = null;
		
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(com);
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
	public boolean updateCommodity(Commodity com) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(com);
			tx.commit();//提交事务
			return true;
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
	public List<Commodity> selectCommodityAll() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<Commodity> comList = null;
		try {
			Session session1 = MyHibernateSessionFactory.getSessionFactory().openSession();
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Commodity";
			Query query = session.createQuery(hql);
			comList = query.list();
			tx.commit();//提交事务
			return comList;
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return comList;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public List<Commodity> selectCommodityBycName(String comName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commodity selectCommodityById(String comId) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Commodity comm = null;
		
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			comm = (Commodity)session.get(Commodity.class, comId);
			tx.commit();//提交事务
			return comm;
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

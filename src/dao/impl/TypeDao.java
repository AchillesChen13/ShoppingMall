package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.ITypeDao;
import db.MyHibernateSessionFactory;
import entity.CommodityType;

public class TypeDao implements ITypeDao{

	@Override
	public CommodityType selectCommodityTypeById(int id) {
		// TODO Auto-generated method stub
		int rs=-1;
		Transaction tx = null;
		CommodityType type = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			
			type = (CommodityType)session.get(CommodityType.class, id);
			if (type!=null) {
				rs = type.getTypeNo();
				return type;
			}
			return type;
			
		}catch (Exception e) {
			e.printStackTrace();
			return type;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public boolean insertCommodityType(String typeName) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		CommodityType type = new CommodityType();
		type.setTypeName(typeName);
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(type);
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
	public List<CommodityType> selectCommodityTypeById() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<CommodityType> tplist = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from CommodityType";
			Query query = session.createQuery(hql);
			tplist = query.list();
			tx.commit();//提交事务
			return tplist;
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return tplist;
		}
		finally {
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public boolean updateCommodityType(CommodityType type) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(type);
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

}

package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.IAddressDao;
import db.MyHibernateSessionFactory;
import entity.Address;
import entity.User;

public class AddressDao implements IAddressDao {

	@Override
	public List<Address> selectAddressByUserId(int id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<Address> addressList = null;

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Address where userId = " + id;
			Query query = session.createQuery(hql);
			addressList = query.list();
			addressList = sortByDefaultId(addressList);
			tx.commit();
			return addressList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return addressList;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean insertAddress(Address address) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(address);
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
	public boolean deleteAddressById(int aId) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Address address = (Address) session.get(Address.class, aId);
			session.delete(address);
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
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(address);
			tx.commit();// 提交事务
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public Address selectAddressById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Address add = null;

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			add = (Address) session.get(Address.class, id);
			tx.commit();
			return add;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public Address selectAddressByDefalutId(int uId,int DefalutId) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		List<Address> addresslist= null;
		Address defaultAddress = null;
		
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Address where IsDefault="+DefalutId+"and userId="+uId;
			Query query = session.createQuery(hql);
			addresslist  = query.list();
			tx.commit();
			if (addresslist.size()!=0) {
				defaultAddress = addresslist.get(0);
				return defaultAddress;
			}
			return defaultAddress;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return defaultAddress;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public List<Address> sortByDefaultId(List<Address> addresslist) {
		// TODO Auto-generated method stub
		Address t = null;
		for (int i=0;i<addresslist.size()-1;i++) {
			for (int j=i+1;j<addresslist.size();j++) {
				if (addresslist.get(i).getIsDefault()<addresslist.get(j).getIsDefault()) {
					t = addresslist.get(i);
					addresslist.set(i, addresslist.get(j));
					addresslist.set(j, t);
				}
			}
		}
		return addresslist;
	}

	// @Override
	// public int selectAddressByUId(int uId) {
	// // TODO Auto-generated method stub
	// Transaction tx = null;
	// int rs = -1;
	// String hql = "";
	// try {
	// Session session =
	// MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
	// tx = session.beginTransaction();
	// hql = "from Address where userId=?";
	// Query query = session.createQuery(hql);
	// query.setParameter(0, uId);
	// List<Address> list = query.list();
	// tx.commit();//提交事务
	// if (list.size()>0) {
	// rs = 1;
	// }
	// return rs;
	// }catch (Exception e) {
	// e.printStackTrace();
	// tx.commit();
	// return rs;
	// }
	// finally {
	// if (tx!=null) {
	// tx=null;
	// }
	// }
	// }

}

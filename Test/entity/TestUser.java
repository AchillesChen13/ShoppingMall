package entity;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Assert;
import org.junit.Test;

import dao.IUserDao;
import dao.impl.UserDao;

public class TestUser {
	@Test
	public void testSchemaExport() {
		//创建一个配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建sessionFactory
		//SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//创建session对象
		//Session session = sessionFactory.getCurrentSession();
		//创建SchemaExport对象
		SchemaExport export = new SchemaExport(config);
		export.create(true, true);
	}
	
//	@Test
//	public void testMethod() {
//		IUserDao dao = new UserDao();
//		User user = null;
////		user.setMenmber(0);
////		user.setPassword("123456");
//////		user.setUserName("陈");
////		user.setUserPhone("15684168890");
//////		Assert.assertEquals(true, dao.userRegiste(user));
//		System.out.println(dao.queryUserByPhone("15684171317"));
////		Assert.assertEquals(true, dao.userLogin(user));
//		System.out.println(222);
//		user = dao.selectUserById(dao.queryUserByPhone("15684171317"));
//		System.out.println(user.toString());
//	}
}

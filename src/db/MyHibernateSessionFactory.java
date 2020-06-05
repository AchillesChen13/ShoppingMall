package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
	
	private static SessionFactory sessionFactory;//会话工厂属性
	
	//构造方法私有化保证单例模式
	private MyHibernateSessionFactory() {
		
	}
	
	//公有的静态方法获得会话工厂对象
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory==null) {
			Configuration config = new Configuration().configure();
			//创建服务注册对象
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			//创建sessionFactory
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
		}
		else {
			return sessionFactory;
		}
	}
}

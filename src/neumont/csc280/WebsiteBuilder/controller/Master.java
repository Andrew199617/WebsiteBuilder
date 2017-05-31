package neumont.csc280.WebsiteBuilder.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import neumont.csc280.WebsiteBuilder.model.HibernateEngine;

public class Master implements ServletContextListener{
	private static HibernateEngine hibernateEngine = new HibernateEngine();
	
	private static SessionFactory sessionFactory;
	
	public static HibernateEngine getHibernateEngine() {
		return hibernateEngine;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent e) {

		StandardServiceRegistry standardRegistery =
				new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
		Metadata metaData = new MetadataSources(standardRegistery).getMetadataBuilder().build();
		sessionFactory = 
			metaData.getSessionFactoryBuilder().build();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}

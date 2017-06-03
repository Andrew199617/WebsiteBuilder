package neumont.csc280.WebsiteBuilder.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@WebListener
public class HibernateUtil implements ServletContextListener {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent e) {
		StandardServiceRegistry standardRegistery = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		Metadata metaData = new MetadataSources(standardRegistery)
				.getMetadataBuilder().build();
		sessionFactory = metaData.getSessionFactoryBuilder().build();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		getSessionFactory().close();
	}
}

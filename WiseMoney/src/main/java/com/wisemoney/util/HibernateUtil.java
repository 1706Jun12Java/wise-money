package com.wisemoney.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = sessionFactory();
	private static Session session;
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
	public void closeSession() {
		if(session.isOpen())
			session.close();
	}

	private static synchronized SessionFactory sessionFactory() {
		Properties prop = new Properties();

		Configuration c = null;
		
		InputStream resourceAsStream = null;

		try {

//			classLoader = Thread.currentThread().getContextClassLoader();
//			input = classLoader.getResourceAsStream("env.properties");
//			Properties prop = new Properties();
//			prop.load(input);
			resourceAsStream = HibernateUtil.class.getClassLoader().getResourceAsStream("env.properties");

			// load a properties file
			prop.load(resourceAsStream);
			c = new Configuration().configure("hibernate.cfg.xml");

			c.setProperty("hibernate.connection.url", prop.getProperty("HIB_URL"))
			 .setProperty("hibernate.connection.username", prop.getProperty("HIB_USERNAME"))
			 .setProperty("hibernate.connection.password", prop.getProperty("HIB_PASSWORD"));
//		     .configure(filename);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (resourceAsStream != null) {
				try {
					resourceAsStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
   		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
        return c.buildSessionFactory(sr);
    }
	
//	public static SessionFactory setSessionFactory() {
//		return sessionFactory("hibernate.cfg.xml");
//	}

}
package com.wisemoney.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//public class HibernateUtil {
//
//	private static SessionFactory sessionFactory(String filename) {
//		Configuration c = new Configuration().configure(filename);
//		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(
//				c.getProperties()).build();
//		return c.buildSessionFactory(sr);
//	}
//
//	public static Session getSession() {
//		return sessionFactory("hibernate.cfg.xml").openSession();
//	}
//}

public class HibernateUtil {

	private static SessionFactory sessionFactory(String filename) {

		Configuration c = new Configuration();

		ClassLoader classLoader = null;
		InputStream input = null;
		try {

			classLoader = Thread.currentThread().getContextClassLoader();
			input = classLoader.getResourceAsStream("env.properties");
			Properties prop = new Properties();
			prop.load(input);

			// load a properties file
			prop.load(input);
			c.setProperty("hibernate.connection.url", prop.getProperty("HIB_URL"))
			 .setProperty("hibernate.connection.username", prop.getProperty("HIB_USERNAME"))
			 .setProperty("hibernate.connection.password", prop.getProperty("HIB_PASSWORD"))
		     .configure(filename);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

   		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
        return c.buildSessionFactory(sr);
    }

    public static Session getSession() {
        return sessionFactory("hibernate.cfg.xml").openSession();
    }
}
package com.cts.spring.jpa.handsOn2.Application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cts.spring.jpa.handsOn2.pojo.Country;

public class Application {

	public static void main(String args[]) {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Country country = new Country("AF", "Afghanistan");
		session.save(country);
		transaction.commit();
	}}

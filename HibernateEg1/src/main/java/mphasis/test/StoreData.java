package mphasis.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class StoreData {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf =  cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Book b = new Book();
		b.setId(1);
		b.setB_name("HP");
		b.setB_price(200);
		
		session.save(b);
		t.commit();
		System.out.println("Done");
		session.close();
	}

}

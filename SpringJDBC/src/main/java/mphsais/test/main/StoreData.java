package mphsais.test.main;

import java.util.List;

import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import mphasis.test.dao.CustDao;

import mphasis.test.model.Customer;

public class StoreData {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		Customer obj = new Customer();
//		obj.setName("Rohit");
//		obj.setType("Regular");
		obj.setName("Ashwin");
		obj.setType("Regular");
//		obj.setName("Rahul");
//		obj.setType("irRegular");
		CustDao cst = ctx.getBean("custDao",CustDao.class);
//		cst.createCustomer(obj);
		//cst.deleteCustomer(obj);
		//cst.updateCustomer(obj);
		List<Customer> ls = cst.getAllCustomer(obj);
		System.out.println(ls);
	}
	
}

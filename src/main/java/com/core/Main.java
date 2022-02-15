package com.core;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.binoy.pojo.HibernateUtil;
import com.binoy.pojo.User;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory= HibernateUtil.getSessionFactory();
		Session session= null;
		
	//Below adds new row  tp the the table.
		/*session.beginTransaction();
		User user = session.find(User.class, 123);
		Address addr=new Address();
		addr.setAddr("test");
		addr.setCountry("testCntry");
		addr.setId(123);
		addr.setUser(user);
		
		Address addr2=new Address();
		addr2.setAddr("test");
		addr2.setCountry("testCntry");
		addr2.setId(123);
		addr2.setUser(user);
		session.save(addr2);
		session.save(addr);
		
		session.getTransaction().commit();
		*/
	try {
		
	//The below code insert one user row to user table. And add 2 addresses
	//to address list.And set the addressList to this user. one to many
	//implementation.
		/*
	session=factory.openSession();
	session.beginTransaction();
		
	User user= new User();
	user.setId(2);
	user.setName("Andria");
	user.setPhone("4088160000");
	user.setDob(new Date());
	user.setUsername("and");
	user.setPassword("ria");
	
	
	
	Address address1= new Address();
		address1.setId(4);
		address1.setAddr("sanjose");
		address1.setCountry("CA");
		address1.setUser(user);
		
	Address address2= new Address();
		address2.setId(5);
		address2.setAddr("Milpitas");
		address2.setCountry("CA");
		address2.setUser(user);
		
	List<Address> addresses= new ArrayList<Address>();		
		addresses.add(address1);
		addresses.add(address2);
		
		user.setAddressList(addresses);
		session.save(user);
		session.save(address1);
		session.save(address2);
		
		session.getTransaction().commit();
		*/
		
		
	session=factory.openSession();
	Query query=session.createQuery("from User where name= :param");
	query.setParameter("param", "nija");
	
	List<User> userList= query.getResultList();
	for(User user:userList) {
		System.out.println(user.getName()+ " "+ user.getPhone());
	}
		
		
	}
	catch(Exception e) {
		session.getTransaction().rollback();
	}
	finally {
		session.close();
	}
		System.out.println("Exit");
	
		
	}

}

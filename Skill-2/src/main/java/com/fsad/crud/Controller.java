package com.fsad.crud;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Controller {
	public static void main(String args[])
	{
		Controller c=new Controller();
			//c.addvalues();
			//c.display();
		c.delete();
		//c.update();
		}
	
	public void addvalues()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		Product p=new Product();
	
		p.setName("yash");
		p.setDescription("Product1");
		p.setPrice(10000.2355);
		p.setQuantity(12);
		Transaction t= session.beginTransaction();
		session.persist(p);
		t.commit();
		System.out.println("I have added record on my wish..");
		session.close();
		sf.close();
	}
	public void display()
	{
		Configuration cfg =new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf= cfg.buildSessionFactory();
		
		Session session= sf.openSession();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("id to fetch");
		int id=sc.nextInt();
		Product s=session.find(Product.class, id);
		if(s!=null)
		{
			System.out.println(s.toString());
		}
		else
		{
			System.out.println("ID NOT Found");
		}
		sc.close();
		session.close();
		sf.close();
		
		
		}
	public void delete() {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter id to delete");
		int id = sc.nextInt();
		
		Product s=session.find(Product.class, id);
		Transaction t= session.beginTransaction();
		if(s!=null)
		{
			session.remove(s);
			t.commit();
			System.out.println("removed the record");
		}
		else
		{
			System.out.println("ID NOT Found");
		}
		sc.close();
		session.close();
		sf.close();
		
	}
	public void update()
	{
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter id to update/modify");
		int id= sc.nextInt();
		Product s=session.find(Product.class, id);
		Transaction t=session.beginTransaction();
		if(s!=null)
		{
			System.out.println("Id found to update ");
			System.out.println("Enter price");
			double price=sc.nextDouble();
			System.out.println("Enter quantity");
			int quan=sc.nextInt();

			s.setPrice(price);
			s.setQuantity(quan);
			t.commit();
			System.out.println("record updated as per your request");
		}
		else
		{
			System.out.println("Unable to modify because we cant get the id");
		}
		sc.close();
		session.close();
		sf.close();
		
		
	}
	

}

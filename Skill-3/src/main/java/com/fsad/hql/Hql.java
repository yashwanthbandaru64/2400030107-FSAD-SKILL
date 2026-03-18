package com.fsad.hql;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;



public class Hql
{
   public static void main(String args[])
   {
	   Hql demo = new Hql();
	   demo.addProduct();
	   demo.displayproductscompleteobject();
	   //demo.updateproductpositionalparams();
	   //demo.deleteproductpositionalparams();
	   //demo.updateproductnamedparams();
	  // demo.deleteproductnamedparams();
	  // demo.aggregatefunctions();
	   //demo.selectpositionalparams();
	  //demo.selectnamedparams();
	  //demo.displayproductspartialobject();
	  // demo.sortingdemo();
	  // demo.selectlikeoperatordemo();
	  //demo.pagination();
   }
   public void addProduct()
   {
	   Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	        
	   SessionFactory sf = cfg.buildSessionFactory();
	        
	   Session session = sf.openSession();
	        
	   Product  p = new Product();   // Transient State
	  p.setDescription("product2");
	   p.setName("toys");
	   p.setPrice(10000.0231);
	   p.setQuantity(75);
	        
	   Transaction t = session.beginTransaction();
	        
	   session.persist(p);    // Persistent State
	        
	   t.commit();
	        
	   System.out.println("Product Added Successfully");
	        
	   session.close();  // Detached State
	   sf.close();
  }
   //display products with all 5 properties
   public void displayproductscompleteobject()
   {
	   Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	   Session session=sf.openSession();
	   
	   String hql="from Product";//where Product is a class name
	   //sql-select * from product_table
	   
	   Query<Product> qry = session.createQuery(hql, Product.class);
	   List<Product> productlist =qry.getResultList();
	   
	   System.out.println("Total Products="+productlist.size());
	   for(Product p:productlist)//runs for each object record
	   {
		   System.out.println(p.toString());
		   //we can use getter methods also to display properties individually
	   }
	   session.close();
	   sf.close();
	   
	   }
   public void updateproductpositionalparams()
   {
	   Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	   Session session=sf.openSession();
	   Transaction t=session.beginTransaction();
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter Product Id:");
	   int pid=sc.nextInt();
	   System.out.println("Enter Product Name:");
	   String pname=sc.next();
	   System.out.println("Enter Product quantity");
	   int pqua=sc.nextInt();
	   //updating product name and stock based on ID
	   
	   String hql="update Product set name=?1,quantity=?2 where id=?3";
	   
	   MutationQuery qry=session.createMutationQuery(hql);
	   qry.setParameter(1, pname);
	   qry.setParameter(2, pqua);
	   qry.setParameter(3, pid);
	   
	   int n=qry.executeUpdate();//n indicates number of records updated
	   t.commit();
	   System.out.println(n+"Products updated successfully");
	   sc.close();
	   session.close();
	   sf.close();
	   
	   
	  }
   public void deleteproductpositionalparams()
   {
	   Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	   Session session=sf.openSession();
	   Transaction t=session.beginTransaction();
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter Product Id:");
	   int pid=sc.nextInt();
	   //deleting products based on product id
	   
	   String hql="delete from Product where id=?1";
	   
	   MutationQuery qry=session.createMutationQuery(hql);
	   
	   qry.setParameter(1, pid);
	   
	   int n=qry.executeUpdate();
	   t.commit();
	   if(n>0)
	   {
		   System.out.println(n+"Products deleted successfully");
	   }
	   else
	   {
		   System.out.println("Products Id Not Found");
	   }
	   
	   sc.close();
	   session.clear();
	   sf.close();
	   
	   
	   
	   
   }
   public void updateproductnamedparams()
   {

	   Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	   Session session=sf.openSession();
	   Transaction t=session.beginTransaction();
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter Product Id:");
	   int pid=sc.nextInt();
	   System.out.println("Enter Product Name:");
	   String pname=sc.next();
	   System.out.println("Enter Product quantity");
	   int pqua=sc.nextInt();
	   
	   //updating product name and stock based on its id
	   
	   String hql="update Product set name=:v1,quantity=:v2 where id=:v3";
	   
	   MutationQuery qry=session.createMutationQuery(hql);
	   
	   qry.setParameter("v1", pname);
	   qry.setParameter("v2",pqua);
	   qry.setParameter("v3", pid);
	   
	   int n=qry.executeUpdate();// n products updated
	   t.commit();
	   if(n>0) {
	   System.out.println(n+"Products updated successfully");
	   }
	   else {
		   System.out.println("Product Id Not Found");
	   }
	   sc.close();
	   session.close();
	   sf.close();
   }
   public void deleteproductnamedparams()
   {

	   Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	   Session session=sf.openSession();
	   Transaction t=session.beginTransaction();
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter Product Id:");
	   int pid=sc.nextInt();
	   //deleting products based on product id
	   String hql="delete from Product where id=:pid";
	   
	   MutationQuery qry=session.createMutationQuery(hql);
	   
	   qry.setParameter("pid", pid);
	   int n=qry.executeUpdate();//n indicates number of products updated
	   t.commit();
	   
	   if(n>0)
	   {
		   System.out.println(n+"Products deleted successfully");
	   }
	   else
	   {
		   System.out.println("Product Id Not Found");
	   }
	   
	   sc.close();
	   session.close();
	   sf.close();
	   
   }
   public void aggregatefunctions()
   {
	   Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	   Session session=sf.openSession();
	   
	   
	   String hql1="select count(*) from Product";
	   
	   Query<Long> qry1=session.createQuery(hql1, Long.class);
	   Long count=qry1.getSingleResult();
	   System.out.println("Total products="+count);
	   
       String hql2="select sum(price) from Product";
	   
	   Query<Double> qry2=session.createQuery(hql2, Double.class);
	   Double totalcost=qry2.getSingleResult();
	   System.out.println("Sum of all Product's price="+totalcost);
	   
       String hql3="select avg(price) from Product";
	   
	   Query<Double> qry3=session.createQuery(hql3, Double.class);
	   Double avgcost=qry3.getSingleResult();
	   System.out.println("average of all Product's price="+avgcost);
	   
       String hql4="select min(quantity) from Product";
	   
	   Query<Integer> qry4=session.createQuery(hql4, Integer.class);
	   Integer minstock=qry4.getSingleResult();
	   System.out.println(" Minimum Product quantity="+minstock);
	   
	      String hql5="select max(quantity) from Product";
		   
		   Query<Integer> qry5=session.createQuery(hql5, Integer.class);
		   Integer maxstock=qry5.getSingleResult();
		   System.out.println(" Maximum Product quantity="+maxstock);
		   session.close();
		   sf.close();

   
   }
   public void selectpositionalparams()
   {
	   Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	   Session session=sf.openSession();
	   
	   Scanner sc=new Scanner(System.in);
	   
	   System.out.println("Enter Product category");
	   String pname=sc.next();
	   
	   int pqua=sc.nextInt();
	   String hql="from Product where name=?1 and quantity>?2";
	   

	   Query<Product> qry=session.createQuery(hql, Product.class);
	   
	   qry.setParameter(1, pname);
	   qry.setParameter(2, pqua);
       List<Product> productlist =qry.getResultList();
	   
	   System.out.println("Total Products="+productlist.size());
	   for(Product p:productlist)
	   {
		   System.out.println(p.toString());
		   //we can use getter methods also to display properties individually
	   }
	   sc.close();
	   session.close();
	   sf.close();
	
   }
   public void selectnamedparams()
   {
	   Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	   Session session=sf.openSession();
	   
	   Scanner sc=new Scanner(System.in);
	   
	   System.out.println("Enter Product Name");
	   String pName=sc.next();
	   System.out.println("Enter Product quantity");
	   int pqua=sc.nextInt();
	   String hql="from Product where name=:v1 and quantity>:v2";// we can use any parameter instead v1 and v2
	   

	   Query<Product> qry=session.createQuery(hql, Product.class);
	   
	   qry.setParameter("v1", pName);
	   qry.setParameter("v2", pqua);
       List<Product> productlist =qry.getResultList();
	   
	   System.out.println("Total Products="+productlist.size());
	   for(Product p:productlist)
	   {
		   System.out.println(p.toString());
		   //we can use getter methods also to display properties individually
	   }
	   sc.close();
	   session.close();
	   sf.close();
	
   }
   
   //display products with few properties
   public void displayproductspartialobject()
   {
	   
	   Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	   Session session=sf.openSession();
	   
	   String hql="select p.id,p.name,p.quantity from Product p";  //p is alias or object of type Product
	   
	   Query<Object[]> qry = session.createQuery(hql, Object[].class);
	   List<Object[]> productlist =qry.getResultList();
	   
	   System.out.println("Total Products="+productlist.size());
	   for(Object[] obj:productlist)
	   {
		   System.out.println("Product ID:"+obj[0]);
		   System.out.println("Product NAME:"+obj[1]);
		   System.out.println("Product QUANTITY:"+obj[2]);
		   
	   }
	   session.close();
	   sf.close();
   }
   
// sorting demo asc (ascending) or desc (descending)
   public void sortingdemo()
   {
     Configuration cfg = new Configuration();
     cfg.configure("hibernate.cfg.xml");
          
     SessionFactory sf = cfg.buildSessionFactory();
     Session session = sf.openSession();
     
     String hql = "from Product p order by p.quantity asc limit 1"; //asc or desc
     //limit 1
     
     //stock is property name & product is class name
     
     Query<Product> qry = session.createQuery(hql,Product.class);
     List<Product> productlist = qry.getResultList();
     System.out.println("Total Products="+productlist.size());
     
     for(Product p : productlist)
     {
       System.out.println(p.toString());
     }
     session.close();
     sf.close();
   }
   
// like and not like operator
   public void selectlikeoperatordemo()
   {
     Configuration cfg = new Configuration();
     cfg.configure("hibernate.cfg.xml");
          
     SessionFactory sf = cfg.buildSessionFactory();
          
     Session session = sf.openSession();
    
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter Product Name Pattern:");
     String name_pattern = sc.next();
     System.out.println("Enter Product Cost");
     double pprice = sc.nextInt();   
     
     String hql = "from Product p where p.name not like ?1 and p.price>?2 ";
     
     Query<Product> qry = session.createQuery(hql,Product.class);
     qry.setParameter(1, "%"+name_pattern+"_");
     qry.setParameter(2, pprice);
     
     List<Product> productlist = qry.getResultList();
     
     System.out.println("Total Products="+productlist.size());
     
     for(Product p : productlist)
     {
       System.out.println(p.toString());
    }
     
     sc.close();
     session.close();
     sf.close();
   }
   
   public void pagination()
   {
	   Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	   Session session=sf.openSession();
	   
	   String hql="from Product";
	   
	   Query<Product> qry = session.createQuery(hql, Product.class);
	   
	   qry.setFirstResult(0);//record number starts from 0
	   qry.setMaxResults(1);//maximum/atmost number of records
	   
	   
	   List<Product> productlist =qry.getResultList();
	   
	   System.out.println("Total Products="+productlist.size());
	   for(Product p:productlist)
	   {
		   System.out.println(p.toString());
		   
	   }
	   session.close();
	   sf.close();
	   
	   
   }
   
   
   
   
}

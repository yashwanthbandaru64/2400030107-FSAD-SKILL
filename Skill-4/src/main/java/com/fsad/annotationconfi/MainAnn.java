package com.fsad.annotationconfi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAnn {
		public static void main(String args[]) {
			AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Appconfig.class);
			
			
			Student user = (Student) context.getBean("studentbean");// by bean name
			
			System.out.println(user.toString());//this will print user & certification details

			context.close();
		}
		

	}




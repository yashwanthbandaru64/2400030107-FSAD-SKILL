package com.fsad.xmlconfig;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXML {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationcontext.xml");

        Student s = (Student) context.getBean("student");
        s.display();
       context.close();
    }
}
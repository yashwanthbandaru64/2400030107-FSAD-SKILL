package com.fsad.autowiring;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAnno {
    public static void main(String[] args) {

    	AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Appconfig.class);

        Student s = context.getBean(Student.class);
        s.display();
        context.close();
    }
}

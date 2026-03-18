package com.fsad.annotationconfi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Appconfig {
	@Bean(name="studentbean")
	public Student student()
	{
		Student s= new Student();
		s.setCourse("FSAD");
		s.setYear(2);
		return s;
	}
	

}

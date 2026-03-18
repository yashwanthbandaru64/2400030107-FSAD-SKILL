package com.fsad.autowiring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
	@ComponentScan(basePackages = "com.fsad.autowiring")
	public class Appconfig {
	}


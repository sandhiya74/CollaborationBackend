package com.niit.CollaborationMiddle.Config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*
 * *@Enable Transaction MAngement
 * when there is a communication to db @ enableTransactionManagement---ACID properties of Transaction with a db
 */
@SuppressWarnings("deprecation")
@Configuration
@ComponentScan("com.niit")
@EnableWebMvc//communication is with browser over here mvc architecture 
public class WebConfig extends  WebMvcConfigurerAdapter{

	

	
}

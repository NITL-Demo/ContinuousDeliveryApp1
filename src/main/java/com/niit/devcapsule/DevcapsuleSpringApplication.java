/*
 * 
 */
package com.niit.devcapsule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.util.Properties;
/**
 * The Class DevcapsuleSpringApplication.
 */
 
@SpringBootApplication
public class DevcapsuleSpringApplication extends SpringBootServletInitializer {

  /**
   * The main method.
   *
   * @param args
   *          the arguments
   */
	
 	
  public static void main(String[] args) {
    SpringApplication.run(DevcapsuleSpringApplication.class, args).close();
  }
 
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DevcapsuleSpringApplication.class);
	}
	
	
}

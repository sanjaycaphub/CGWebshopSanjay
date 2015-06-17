package com.cg.petsupply.admin.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author ssukheja
 * Java based configuration of Spring MVC for Webshop Admin Module
 */

@Configuration  
@ComponentScan("com.cg.petsupply.admin.controllers")   
@EnableWebMvc 
public class AdminWebMvcConfig {

	    /**
	     * @return
	     * Registering InternalResourceViewResolver as ViewResolver for this Spring MVC app
	     */
	    @Bean  
	    public InternalResourceViewResolver setupViewResolver() {  
	    	InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
	        resolver.setPrefix("/WEB-INF/views/");  
	        resolver.setSuffix(".jsp");  
	       
	        return resolver;  
	    }	   
	    
	    /**
	     * @return
	     * Registering ResourceBundleMessageSource as a resourcebundle for reading properties file in Spring MVC
	     */	   	    
	    @Bean
	    public ResourceBundleMessageSource setupResourceBundle(){
	    	ResourceBundleMessageSource resourceBundle = new ResourceBundleMessageSource();
	    	resourceBundle.setBasename("messages_en");	    	
	    	return resourceBundle;
	    }	    
	    
}

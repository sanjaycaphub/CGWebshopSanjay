package com.cg.petsupply.users.webconfig;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



/**
 * Java based configuration of Spring MVC for Webshop Users Module
 * @author ssukheja
 * 
 */

@Configuration  
@ComponentScan("com.cg")   
@EnableWebMvc
@EnableCaching
public class UsersWebMvcConfig {
	
		 /**
	     * Registering InternalResourceViewResolver as ViewResolver for this Spring MVC app
	     * @return 
	     */
	    @Bean  
	    public InternalResourceViewResolver setupViewResolver() {  
	    	InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
	        resolver.setPrefix("/WEB-INF/views/");  
	        resolver.setSuffix(".jsp");  
	       
	        return resolver;  
	    }   
	    
	    /**
	     * Registering cachemanager for storing categories list dropdown in Users module
	     * @return
	     */
	    @Bean
	    public CacheManager cacheManager() {	    	
	        return new ConcurrentMapCacheManager("cachedCategories");
	    }
	    
}

package com.cg.petsupply.admin.webconfig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Java based configuration of Spring MVC for Webshop Admin Module
 * @author ssukheja 
 */

@Configuration
@ComponentScan("com.cg.petsupply.admin.controllers")
@EnableWebMvc
public class AdminWebMvcConfig {

	/**
	 * Registering InternalResourceViewResolver as ViewResolver for this Spring
	 * MVC app
	 * 
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
	 * Registering ResourceBundleMessageSource as a resourcebundle for reading
	 * properties file in Spring MVC
	 * 
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource resourceBundle = new ReloadableResourceBundleMessageSource();
		resourceBundle.setBasename("classpath:messages");
		return resourceBundle;
	}

}

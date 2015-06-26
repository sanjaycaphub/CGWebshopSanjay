/**
 * 
 */
package com.cg.petsupply.users.webconfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Initializer class - Java based configuration for Spring MVC mainly to load
 * context and servlet. This class helps avoiding doing these things in Web.xml
 * 
 * @author ssukheja
 *
 */
public class WebAppInitializer implements WebApplicationInitializer {

	
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		WebApplicationContext context = getContext();
		servletContext.addListener(new ContextLoaderListener(context));
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.htm");
	}

	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("com.cg.petsupply.users.webconfig");
		return context;
	}

}

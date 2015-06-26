/**
 * 
 */
package com.cg.petsupply.users.webconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cg.petsupply.users.utils.Constants;

/**
 * Java based annoation configuration for configuring JPA using Spring
 * @author ssukheja
 *
 */
@Configuration 
@EnableTransactionManagement
public class JpaConfig {

	 /**
	 * Register bean using Spring for configuring jpa datasource 
	 * @return
	 */
	@Bean
     public DataSource dataSource() {
             DriverManagerDataSource dataSource = new DriverManagerDataSource();
              
             dataSource.setDriverClassName(Constants.PROPERTY_NAME_DATABASE_DRIVER);
             dataSource.setUrl(Constants.PROPERTY_NAME_DATABASE_URL);
             dataSource.setUsername(Constants.PROPERTY_NAME_DATABASE_USERNAME);
             dataSource.setPassword(Constants.PROPERTY_NAME_DATABASE_PASSWORD);
              
             return dataSource;
     }
      
     /**
     * Registering bean using Spring for defining jpa EntityManagerFactory
     * @return
     */
    @Bean
     public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
             LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
             entityManagerFactoryBean.setDataSource(dataSource());
             entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
             entityManagerFactoryBean.setPersistenceUnitName("p_userunit");
             entityManagerFactoryBean.setPackagesToScan(Constants.PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
                              
             entityManagerFactoryBean.setJpaProperties(hibProperties());
              
             return entityManagerFactoryBean;
     }
      
     private Properties hibProperties() {
             Properties properties = new Properties();
             properties.put("hibernate.dialect", Constants.PROPERTY_NAME_HIBERNATE_DIALECT);
             properties.put("hibernate.show_sql", Constants.PROPERTY_NAME_HIBERNATE_SHOW_SQL);
             properties.put("hibernate.hbm2ddl.auto", Constants.PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO);
             properties.put("hibernate.format_sql", true);
             return properties;        
     }
      
     /**
     * Registering bean using Spring for defining transaction manager for database transactions
     * @return
     */
    @Bean
     public JpaTransactionManager transactionManager() {
             JpaTransactionManager transactionManager = new JpaTransactionManager();
             transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
             return transactionManager;
     }

}

package com.praveen.init;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.hibernate.ejb.HibernatePersistence;
import org.hibernate.validator.constraints.Email;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.praveen.messaging.EmailProperty;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.praveen")
@PropertySource("classpath:config/application.properties")
@EnableJpaRepositories("com.praveen.repository")
public class WebAppConfig  extends WebMvcConfigurerAdapter{

	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	private static final String PROPERTY_NAME_DATABASE_PLATEFORM = "db.databasePlatform";
	
	

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	
	private static final Boolean  PROPERTY_NAME_MAIL_AUTHENTICATION = true;
	private static final Boolean PROPERTY_NAME_MAIL_ENABLESSL = true;
	private static final String PROPERTY_NAME_MAIL_HOST = "mail.host";
	private static final Integer PROPERTY_NAME_MAIL_PORT= 587;
	private static final String PROPERTY_NAME_MAIL_USERNAME = "mail.username";
	private static final String PROPERTY_NAME_MAIL_PASSWORD = "mail.password";
	
		
		
	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
		entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
		
		entityManagerFactoryBean.setJpaProperties(hibProperties());
		
		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,	env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
		return properties;
	}

	
/*	private Properties mailProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_MAIL_AUTHENTICATION,	env.getRequiredProperty(PROPERTY_NAME_MAIL_AUTHENTICATION));
		properties.put(PROPERTY_NAME_MAIL_HOST,	env.getRequiredProperty(PROPERTY_NAME_MAIL_HOST));
		properties.put(PROPERTY_NAME_MAIL_PORT,	env.getRequiredProperty(PROPERTY_NAME_MAIL_PORT));
		properties.put(PROPERTY_NAME_MAIL_USERNAME,	env.getRequiredProperty(PROPERTY_NAME_MAIL_USERNAME));
		properties.put(PROPERTY_NAME_MAIL_PASSWORD,	env.getRequiredProperty(PROPERTY_NAME_MAIL_PASSWORD));
		properties.put(PROPERTY_NAME_MAIL_ENABLESSL,	env.getRequiredProperty(PROPERTY_NAME_MAIL_ENABLESSL));
		
		return properties;
	}*/

	
	@Bean
	public EmailProperty mailProperty(){;
	EmailProperty emailProps = new EmailProperty();
	emailProps.setAuthentication(PROPERTY_NAME_MAIL_AUTHENTICATION);
	emailProps.setEnableSSL(PROPERTY_NAME_MAIL_ENABLESSL);
	emailProps.setHost(env.getProperty(PROPERTY_NAME_MAIL_HOST));
	emailProps.setUsername(env.getProperty(PROPERTY_NAME_MAIL_USERNAME));
	emailProps.setPassword(env.getProperty(PROPERTY_NAME_MAIL_PASSWORD));
	emailProps.setPort(PROPERTY_NAME_MAIL_PORT);
	
	return emailProps;
	
	
	}
     
	
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	
	
	   @Bean
	    public JpaVendorAdapter jpaVendorAdapter() {
	    	
	    	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    	adapter.setShowSql(true);
	    	adapter.setGenerateDdl(true);
	    	adapter.setDatabase(Database.MYSQL);
	    	adapter.setDatabasePlatform(PROPERTY_NAME_DATABASE_PLATEFORM);
	    	
	        
	    	
	    	return adapter;
	    }
	   
	   @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    }
	 
	    @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	
	    @Bean
	    public VelocityEngine velocityEngine() throws VelocityException, IOException{
	    	VelocityEngineFactoryBean factory = new VelocityEngineFactoryBean();
	    	Properties props = new Properties();
	    	props.put("resource.loader", "class");
	    	props.put("class.resource.loader.class", 
	    			  "org.apache.velocity.runtime.resource.loader." + 
	    			  "ClasspathResourceLoader");
	    	factory.setVelocityProperties(props);
	    		    	return factory.createVelocityEngine();
	    }
	    
	
}

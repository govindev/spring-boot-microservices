package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		// If you want to use the @RequestHeader
		// SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		
		// If you want to use the LocaleContext
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
//Same can be done from the application.properties file by putting spring.messages.basename=messages
//	@Bean
//	public ResourceBundleMessageSource bundleMessageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//	}

}

package com.in28minutes.rest.webservices.restfulwebservices.hellowWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	// hellow-world-bean
	@GetMapping(path = "/hello-world-bean")
	public HellowWorldBean helloWorldBean() {
		return new HellowWorldBean("Hello World");
	}

	// hellow-world-bean/path-variable/govind
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HellowWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HellowWorldBean("Hello World, " + name);
	}
 
	@GetMapping(path = "/hello-world-internationlized")
	public String helloWorldBeanInternationalized(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
}

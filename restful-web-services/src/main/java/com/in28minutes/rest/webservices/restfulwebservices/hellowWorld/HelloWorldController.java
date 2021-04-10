package com.in28minutes.rest.webservices.restfulwebservices.hellowWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {

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
}
 
package com.in28minutes.rest.webservices.restfulwebservices.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService service;

	// GET /users
	// retrieveAllUsers
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return service.findOne(id);
	}

//	@RequestMapping(method = RequestMethod.POST, path = "/users/")
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		User savedUser = service.save(user);
	}
}

package com.nagarro.ProductCatalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ProductCatalog.model.User;
import com.nagarro.ProductCatalog.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//get all users
	@GetMapping
	public List<User> getAllUsers() throws Exception {
		try {
			return userService.findAll();
		}
		catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}
	
	//create user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
		try {
			if(userService.findByName(user.getName()) == user) {
				return null;
			}
			return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
		}
		catch (Exception e) {
			return null;
		}
	}
	
//	// get user by user_id
//	@GetMapping("/{id}")
//	public User getUserById(@PathVariable("id") long userId) {
//		return (User) this.userRepository.findById(userId);
//	}
//	
	//get user by username
	@GetMapping("/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable("name") String userName) {
		try {
			return new ResponseEntity<User>(userService.findByName(userName), HttpStatus.OK);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	// get user by name and password
	@PostMapping("/{name}/{password}")
	public ResponseEntity<User> getUserByNameAndPassword(@PathVariable("name") String userName, @PathVariable("password") String userPassword) {
		try {
		return new ResponseEntity<User>(userService.findByNameAndPassword(userName, userPassword), HttpStatus.OK);
		} catch (Exception e) {
			return null;
		}
	}
	
	// login API
//	@PostMapping("/login")
//	public ResponseEntity<User> login(@RequestBody User user) {
//		try {
//			return new ResponseEntity<User>(userService.findByNameAndPassword(user.getName(), user.getPassword()), HttpStatus.OK);
//		}
//		catch (Exception e) {
//			return null;
//		}
//	}
	
	// login By other
	@PostMapping("/login")
	public boolean login(@RequestBody User user) throws Exception {
		User validuser = userService.findByNameAndPassword(user.getName(), user.getPassword());
		if(validuser != null) {
			return true;
		}
		else {
			return false;
		}
	}
}

package com.nagarro.ProductCatalog.service;

import com.nagarro.ProductCatalog.model.User;
import java.util.List;

public interface UserService {
	public User findByName(String username);
	public User findByNameAndPassword(String username, String password);
	public List<User> findAll();
	public User save(User user);
}
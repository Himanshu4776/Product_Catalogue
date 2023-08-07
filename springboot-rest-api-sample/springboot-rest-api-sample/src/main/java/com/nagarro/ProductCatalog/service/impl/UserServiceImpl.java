package com.nagarro.ProductCatalog.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.ProductCatalog.dao.UserRepository;
import com.nagarro.ProductCatalog.model.User;
import com.nagarro.ProductCatalog.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByname(username);
	}

	@Override
	public User findByNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userRepository.findByNameAndPassword(username,password);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		if(findByName(user.getName()) == user) {
			return null;
		}
		return userRepository.save(user);
	}
}

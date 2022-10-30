package com.nagarro.ProductCatalog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.nagarro.ProductCatalog.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByname(String username);

	public User findByNameAndPassword(String name, String password);
	
//	public User findById(long userId);
	
	
}

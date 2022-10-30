package com.nagarro.ProductCatalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id")
	private long id;
	
	@Column(name = "User_Name",unique=true)
	private String name;
	
	@Column(name = "first_Name")
	private String firstname;
	
	@Column(name = "last_Name")
	private String lastname;

	@Column(name = "User_Password")
	private String password;

	public User() {
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int id, String name, String firstname, String lastname, String password) {
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}

}

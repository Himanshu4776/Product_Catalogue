package com.nagarro.ProductCatalog.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_Id")
	private long id;
	
	@Column(name = "Product_Code")
	private long code;
	
	@Column(name = "Product_Name")
	private String productName;
	
	@Column(name="price")
	private long price;

	@Column(name = "Product_Description")
	private String description;
	
	@Column(name = "Brand")
	private String brand;
	
	@Column(name = "Product_Image")
	private String productImage;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", productName=" + productName + ", price=" + price
				+ ", description=" + description + ", brand=" + brand + ", productImage=" + productImage + "]";
	}
}

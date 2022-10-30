package com.nagarro.ProductCatalog.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;

import com.nagarro.ProductCatalog.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductByCode(long productCode);
	long getProductPriceByCode(long code);
	Map<Long, Long> getAllProductPrice();
	List<Product> searchProduct(long code,String brand,String productName);
//	List<Product>findByName(String name);
//	Boolean pincode(int pincode);
//	List<Product>findByPriceFilter(long minvalue, long maxvalue);
}

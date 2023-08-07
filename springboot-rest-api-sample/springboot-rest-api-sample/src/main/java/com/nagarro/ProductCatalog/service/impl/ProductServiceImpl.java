package com.nagarro.ProductCatalog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.nagarro.ProductCatalog.dao.ProductRepository;
import com.nagarro.ProductCatalog.exception.ResourceNotFoundException;
import com.nagarro.ProductCatalog.model.Product;
import com.nagarro.ProductCatalog.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductByCode(long productCode) {
		// TODO Auto-generated method stub
		Product productVariable = productRepository.findByCode(productCode);
		if(productVariable == null) {
			new ResourceNotFoundException("Product","code",productVariable.getCode());
		}
		return productRepository.findByCode(productCode);
	}

	@Override
	public long getProductPriceByCode(long code) {
		Product productVariable = productRepository.findByCode(code);
		if(productVariable == null) {
			new ResourceNotFoundException("Product","code",productVariable.getCode());
		}
		return productVariable.getPrice();
	}

	@Override
	public Map<Long, Long> getAllProductPrice() {
		List<Product> products = getAllProducts();
    	Map<Long, Long> productMap= new HashMap<>();
    	for( Product product:products) {
    		productMap.put(product.getCode(),product.getPrice());
    	}
    	return productMap;
	}

	@Override
	public List<Product> searchProduct(long code, String brand, String productName) {
		List<Product> results = new ArrayList<Product>();
		if(code == 0L && brand == "" && productName != "") {
			return productRepository.findByName(productName);
		}
		else if(code == 0L && brand != "" && productName == "") {
			return productRepository.findByBrand(brand);
		}
		else if(code != 0L && brand == "" && productName == "") {
			Product p = productRepository.findByCode(code);
			results.add(p);
			return results;
		}
		else if(code != 0L && brand != "" && productName == "") {
			return productRepository.findByCodeAndBrand(code, brand);
		}
		else if(code != 0L && brand == "" && productName != "") {
			return productRepository.findByCodeAndName(code, productName);
		}
		else if(code == 0L && brand != "" && productName != "") {
			return productRepository.findByNameAndBrand(productName, brand);
		}
		else if(code != 0L && brand != "" && productName != "") {
			return productRepository.findByCodeAndBrandAndName(code, brand, productName);
		}
		else {
			return null;
		}
	}

}

package com.nagarro.ProductCatalog.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.nagarro.ProductCatalog.model.Product;
import com.nagarro.ProductCatalog.service.ProductService;
import com.nagarro.ProductCatalog.service.impl.ProductServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping
    public List<Product> getAllProducts() throws Exception {
        try {
        	return this.productService.getAllProducts();        	
        }
        catch(Exception e) {
        	System.out.println(e);
        	return null;
        }
    }
	
	//get product by produtCode
    @GetMapping("/{code}")
    public ResponseEntity<Product> getProductByCode(@PathVariable("code") long productCode) throws Exception {
        try {
        	return new ResponseEntity<Product>(productService.getProductByCode(productCode), HttpStatus.OK);
        }
        catch (Exception e) {
        	System.out.println(e);
        	return null;
        }
    }
//    
  //get product price by code
    @GetMapping("/{code}/price")
    public ResponseEntity<Long> getProductPriceByCode(@PathVariable("code") long code) throws Exception {
    	try {    		
    		return new ResponseEntity<Long>(productService.getProductPriceByCode(code), HttpStatus.OK);
    	}
    	catch (Exception e) {
        	System.out.println(e);
        	return null;
        }
    }
//    
    // Api for all products price by their product codes
    @GetMapping("/price/all")
    public Map<Long, Long> getAllProductPrice() throws Exception {
    	try {
    		return this.productService.getAllProductPrice();
    	}
    	catch (Exception e) {
        	System.out.println(e);
        	return null;
        }
    }

    @PostMapping("/search")
    public List<Product> searchProduct(@RequestBody Product product) {
    	try {
    	if(product.getBrand() != null && product.getCode() != 0L && product.getProductName() != null) {
    		
    		return this.productService.searchProduct(product.getCode(),product.getBrand(),product.getProductName());
    	}
    	else if(product.getBrand() == null && product.getCode() != 0L && product.getProductName() != null) {
    		return this.productService.searchProduct(product.getCode(),product.getBrand(),product.getProductName());
    	}
    	else if(product.getBrand() != null && product.getCode() == 0L && product.getProductName() != null) {
    		return this.productService.searchProduct(product.getCode(),product.getBrand(),product.getProductName());
    	}
    	else if(product.getBrand() != null && product.getCode() != 0L && product.getProductName() == null) {
    		return this.productService.searchProduct(product.getCode(),product.getBrand(),product.getProductName());
    	}
    	else if(product.getBrand() == null && product.getCode() == 0L && product.getProductName() != null) {
    		return this.productService.searchProduct(product.getCode(),product.getBrand(),product.getProductName());
    	}
    	else if(product.getBrand() == null && product.getCode() != 0L && product.getProductName() == null) {
    		return this.productService.searchProduct(product.getCode(),product.getBrand(),product.getProductName());
    	}
    	else if(product.getBrand() != null && product.getCode() == 0L && product.getProductName() == null) {
    		return this.productService.searchProduct(product.getCode(),product.getBrand(),product.getProductName());
    	}
//    	return this.productService.searchProduct(product.getCode(),product.getBrand(),product.getProductName());
    	return null;
    }
    	catch (Exception e) {
        	System.out.println(e);
        	return null;
        }
    }
}

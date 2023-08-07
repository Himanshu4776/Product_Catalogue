package com.nagarro.ProductCatalog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.ProductCatalog.model.Product;
import com.nagarro.ProductCatalog.model.User;

public interface ProductRepository extends JpaRepository<Product, Long>{
	public Product findByCode(long code);
//    public Product findByCodeAndPrice(long code, long price);
//    public Product findByCodeAndNameAndBrand(long code, String productName, String brand);
	@Query("select p from Product p where p.productName = :productName")
	public List<Product>findByName(@Param("productName") String productName);
	
	@Query("select p from Product p where p.brand = :brand")
	public List<Product>findByBrand(@Param("brand") String brand);
	
	@Query("select p from Product p where p.code = :code and p.brand = :brand")
	public List<Product>findByCodeAndBrand(@Param("code") long code, @Param("brand") String brand);
	
	@Query("select p from Product p where p.code = :code and p.productName = :productName")
	public List<Product>findByCodeAndName(@Param("code") long code, @Param("productName") String productName);
	
	@Query("select p from Product p where p.brand = :brand and p.productName = :productName")
	public List<Product>findByNameAndBrand(@Param("productName") String productName, @Param("brand") String brand);
	
	@Query("select p from Product p where p.code = :code and p.brand = :brand and p.productName = :productName")
	public List<Product>findByCodeAndBrandAndName(@Param("code") long code,@Param("brand") String brand,@Param("productName") String productName);
}

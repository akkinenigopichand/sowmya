package com.project.MyProjectDemo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.MyProjectDemo.Entity.Product;

public interface ProductInfoRepository extends JpaRepository<Product, Long>{
	
	// public Product getProductById(int id);

}

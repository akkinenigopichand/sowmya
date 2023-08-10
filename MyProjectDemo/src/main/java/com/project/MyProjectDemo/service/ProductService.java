package com.project.MyProjectDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.MyProjectDemo.Entity.Product;
import com.project.MyProjectDemo.Entity.UserInfo;
import com.project.MyProjectDemo.Repo.ProductInfoRepository;
import com.project.MyProjectDemo.Repo.UserInfoRepository;

@Service
public class ProductService {

	List<Product> productList=null;  
	
	@Autowired
	private UserInfoRepository repository;
	
//	@Autowired
//	private ProductInfoRepository productInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<Product> getProducts(){
		return productList;
	}
	
//	public Product getProducts(int id) {
//		return productInfoRepository.stream().filter(product ->product.getId()==id)
//				.findAny()
//				.orElseThrow(()-> new RunTimeException("product"+id+"notFound"));
//	}
	
	public Product getProducts(int id) {
		return productList.stream().filter(product -> product.getId()==id)
				.findAny().orElseThrow(()-> new RuntimeException("product"+id+"notFound"));
		
	}

	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "User Added In DB";
	}

//	public String addProduct(Product product) {	
//		productInfoRepository.save(product);
//		return "Save";
//	}

	
/*	
	public String addProduct(Product product) {
		Product productInfo = new Product();
		productInfo.setId(product.getId());
		productInfo.setName(product.getName());
		productInfo.setPrice(product.getPrice());
		productInfo.setQuantity(product.getQuantity());
		productInfoRepository.save(productInfo);
		return "Product Data Saved Successfully";
	}  */


	@Autowired
	 private ProductInfoRepository productRepository;

	    @Autowired
	    public ProductService(ProductInfoRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	    public Product addProduct(Product product) {
	        return productRepository.save(product);
	    }
	
	
	
}

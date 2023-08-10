package com.project.MyProjectDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.MyProjectDemo.Entity.Product;
import com.project.MyProjectDemo.Entity.UserInfo;
import com.project.MyProjectDemo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	
//	@PostMapping("/new")
//	public String addNewUser(@RequestBody UserInfo userInfo) {
//		
//		return service.addUser(userInfo);
//	}
//	
	/*@PostMapping("/add")
	public String addNewProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}*/
//	 @PostMapping
//	    public Product addProduct(@RequestBody Product product) {
//	        return productService.addProduct(product);
//	    }
	/*
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getAllTheProducts() {
		return "All Product For Admin";
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product getProductById(@PathVariable int id) {
		return service.getProducts(id);
	}*/
	/*
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> getAllTheProducts() {
		return service.getProducts();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product getProductById(@PathVariable int id) {
		return service.getProduct(id);
	}   */

	  private final ProductService productService;

	    @Autowired
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    @PostMapping("/add")
	    public Product addProduct(@RequestBody Product product) {
	        return productService.addProduct(product);
	    }
	

}

package com.project.MyProjectDemo;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.project.MyProjectDemo.Entity.Product;
import com.project.MyProjectDemo.Repo.ProductInfoRepository;
import com.project.MyProjectDemo.controller.ProductController;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
  private MockMvc  mockMvc; 
  
  ObjectMapper objectMapper = new ObjectMapper();
  ObjectWriter objectWriter = objectMapper.writer();
  
  @Mock
  private  ProductInfoRepository productInfoRepository;
  
  @InjectMocks
  private ProductController productController;
  
  Product product= new Product(1,"apple","10",250);
  
  @Before
  public void setUp() {
	MockitoAnnotations.openMocks(this);
	this.mockMvc=MockMvcBuilders.standaloneSetup(productController).build();
  }
}

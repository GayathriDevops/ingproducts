package com.ing.products.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.ing.products.constants.ProductConstants;
import com.ing.products.dto.ProductDetailDto;
import com.ing.products.entity.Category;
import com.ing.products.entity.Product;
import com.ing.products.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	
	ProductConstants productConstants;
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	Product product;
	private Optional<List<Product>> showproducts;
	
	@Before
	public void setUp() {
		
		product =new Product();
		product.setProductId(1);
		product.setProductName("credit");
		product.setDescription("Credit card");
		
	}
	
	@Test
	public void testViewProductDetails() {
		Mockito.when(productRepository.findByProductId(Mockito.anyInt())).thenReturn(product);
		ProductDetailDto productDetailDto= productServiceImpl.viewProductDetails(1);
		Assert.assertEquals(product.getProductId(), productDetailDto.getProduct().getProductId());
	}
	
	@Test
	public void testShowproducts() {
		
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("mortgage");
		
		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("loan");
		product1.setDescription("loan");
		product1.setCategory(category);
		
		ProductDetailDto productDetailDto = new ProductDetailDto();
		productDetailDto.setProduct(product1);
		
		List<Product> prod = new ArrayList<>();
		prod.add(product1);
		Optional<List<Product>> prods = Optional.of(prod);
		
		Mockito.when(productRepository.findAllByProductCategoryId(Mockito.anyInt())).thenReturn(prods);
		Optional<List<Product>> productss = productServiceImpl.showproducts(1);
		Assert.assertEquals("loan", productss.get().get(0).getProductName());
	}

	
}

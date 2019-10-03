package com.ing.products.service;

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
	
}

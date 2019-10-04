package com.ing.products.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.products.dto.CategoryProductResponse;
import com.ing.products.dto.CategoryResponse;
import com.ing.products.entity.Category;
import com.ing.products.entity.Product;
import com.ing.products.service.CategoryService;
import com.ing.products.service.ProductService;


@RunWith(MockitoJUnitRunner.Silent.class)
public class CategoryControllerTest {
	
	@Mock
	CategoryService categoryService;
	
	@Mock
	ProductService productService;
	
	@InjectMocks
	CategoryController categoryController;
	
	@Test
	public void testgetCategories(){
		
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("mortgage");
		
		
		
		List<Category> cat = new ArrayList<>();
		cat.add(category);
		
		Optional<List<Category>> catlist = Optional.of(cat);
		
		Mockito.when(categoryService.getCategories()).thenReturn(catlist);
		
		CategoryResponse categories = categoryController.getCategories();
		
		assertNotNull(categories);
	    assertEquals("mortgage",categories.getCategory().get(0).getCategoryName());
	}
	
	@Test
	public void selectCategory(){ 
		
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("mortgage");
		
		Product product =new Product();
		product.setProductId(1);
		product.setProductName("credit");
		product.setDescription("Credit card");
		product.setCategory(category);
		
		
		List<Product> products = new ArrayList<>();
		products.add(product);
		
		Optional<List<Product>> prolist = Optional.of(products);
		
		Mockito.when(productService.showproducts(Mockito.anyInt())).thenReturn(prolist);
	
		CategoryProductResponse categories = categoryController.selectCategory(1);
		
		assertNotNull(categories);
	    assertEquals("credit",categories.getProducts().get(0).getProductName());
	}
	
	
}

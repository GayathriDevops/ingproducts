package com.ing.products.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.products.entity.Category;
import com.ing.products.repository.CategoryRepository;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.Silent.class)
public class CategoryServiceImplTest {
	
	@Mock
	CategoryRepository categoryRepository;
	
	
	@InjectMocks
	CategoryServiceImpl categoryServiceImpl;
	
	@Test
	public void testGetCategories(){
		
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("mortgage");
		
		List<Category> cat = new ArrayList<>();
		cat.add(category);
		
		Mockito.when(categoryRepository.findAll()).thenReturn(cat);
		
		assertNotNull(cat);
	    assertEquals("mortgage",cat.get(0).getCategoryName());
	}
	
	
	
	
	
	
	
}

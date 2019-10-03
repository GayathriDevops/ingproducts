package com.ing.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.products.entity.Category;
import com.ing.products.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {
		
	@Autowired
	CategoryRepository categoryrepository;
	
	public Optional<List<Category>> getCategories() {
		List<Category> list =categoryrepository.findAll();
		
		return Optional.of(list);
	}

}

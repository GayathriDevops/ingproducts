package com.ing.products.service;

import java.util.List;
import java.util.Optional;

import com.ing.products.entity.Category;


public interface CategoryService {
	
	Optional<List<Category>> getCategories();

}

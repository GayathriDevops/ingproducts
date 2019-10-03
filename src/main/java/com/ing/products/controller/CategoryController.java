package com.ing.products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ing.products.constants.ProductConstants;
import com.ing.products.dto.CategoryProductResponse;
import com.ing.products.dto.CategoryResponse;
import com.ing.products.entity.Category;
import com.ing.products.entity.Product;
import com.ing.products.exception.ProductDoesntExistException;
import com.ing.products.service.CategoryService;
import com.ing.products.service.ProductService;

@RestController
@CrossOrigin(allowedHeaders = {"*","*/"}, origins= {"*","*/"})
public class CategoryController {

	ProductConstants constants;

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryservice;

	@GetMapping(value = "/categories")
	public CategoryResponse getCategories() {

		Optional<List<Category>> resCategory = categoryservice.getCategories();
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setCategory(resCategory.get());
		categoryResponse.setStatusCode(constants.SUCCESS_STATUS_CODE);
		categoryResponse.setMessage("success");

		return categoryResponse;

	}

	
	  @PostMapping(value="/categories/{categoryId}/products") 
	  public CategoryProductResponse selectCategory(@PathVariable int categoryId){ 
	 Optional<List<Product>> productlist = productService.showproducts(categoryId); 
	 List<Product> prods = productlist.get();
	  
	  if(!productlist.isPresent()) throw new
	  ProductDoesntExistException("products doesnt exist");
	  
	  CategoryProductResponse categoryProductResponse = new CategoryProductResponse();
	  categoryProductResponse.setProducts(prods);
	  categoryProductResponse.setStatusCode(constants.SUCCESS_STATUS_CODE);
	  categoryProductResponse.setMessage("success");
	  return categoryProductResponse; }
	 

}

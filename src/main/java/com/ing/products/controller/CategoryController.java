package com.ing.products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ing.products.constants.ProductConstants;
import com.ing.products.dto.CategoryProductResponse;
import com.ing.products.dto.CategoryResponse;
import com.ing.products.entity.Category;
import com.ing.products.entity.Product;
import com.ing.products.exception.CategoryDoesntExistException;
import com.ing.products.exception.ProductDoesntExistException;
import com.ing.products.service.CategoryService;
import com.ing.products.service.ProductService;

@RestController
@CrossOrigin(allowedHeaders = {"*","*/"}, origins= {"*","*/"})
public class CategoryController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryservice;

	@GetMapping(value = "/categories")
	public CategoryResponse getCategories() {

		Optional<List<Category>> resCategory = categoryservice.getCategories();
		
		  if(!resCategory.isPresent()) throw new
		  CategoryDoesntExistException("categories doesnt exist");
		  
		
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setCategory(resCategory.get());
		categoryResponse.setStatusCode(ProductConstants.SUCCESS_STATUS_CODE);
		categoryResponse.setMessage(ProductConstants.SUCCESS_MESSAGE);

		return categoryResponse;

	}

	
	  @GetMapping(value="/categories/{categoryId}") 
	  public CategoryProductResponse selectCategory(@PathVariable int categoryId){ 
	 Optional<List<Product>> productlist = productService.showproducts(categoryId); 
	 
	  if(!productlist.isPresent()) throw new
	  ProductDoesntExistException("products doesnt exist");
	  List<Product> prods = productlist.get();
	  
	  CategoryProductResponse categoryProductResponse = new CategoryProductResponse();
	  categoryProductResponse.setProducts(prods);
	  categoryProductResponse.setStatusCode(ProductConstants.SUCCESS_STATUS_CODE);
	  categoryProductResponse.setMessage("success");
	  return categoryProductResponse; }
	 

}

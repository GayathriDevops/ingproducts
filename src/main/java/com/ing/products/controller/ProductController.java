package com.ing.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.products.dto.ProductDetailDto;
import com.ing.products.service.ProductService;

@RestController
@CrossOrigin(allowedHeaders = {"*","*/"}, origins= {"*","*/"})
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductDetailDto> viewProductDetails(@PathVariable("productId") int productId) {
		ProductDetailDto productDetailDto = productService.viewProductDetails(productId);
		return new ResponseEntity<>(productDetailDto, HttpStatus.FOUND);
}
}
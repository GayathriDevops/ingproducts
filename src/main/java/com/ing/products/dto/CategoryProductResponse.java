package com.ing.products.dto;

import java.util.List;

import com.ing.products.entity.Product;

public class CategoryProductResponse {
	
	private List<Product> Products;
	public List<Product> getProducts() {
		return Products;
	}
	public void setProducts(List<Product> products) {
		Products = products;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String statusCode;
	private String message;
	


}

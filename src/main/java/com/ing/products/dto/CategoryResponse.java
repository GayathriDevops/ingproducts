package com.ing.products.dto;

import java.util.List;

import com.ing.products.entity.Category;

public class CategoryResponse {
	
	List<Category> category;
	String statusCode;
	String message;
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
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

}

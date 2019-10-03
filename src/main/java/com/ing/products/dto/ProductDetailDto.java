package com.ing.products.dto;

import java.io.Serializable;
import java.util.List;

import com.ing.products.entity.Product;



public class ProductDetailDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;
    private String statusCode;
     public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product2) {
		this.product = product2;
	}
	Product product;
	
	

}

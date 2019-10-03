package com.ing.products.exception;

public class ProductDoesntExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductDoesntExistException(String arg0) {
		super(arg0);
	}

}

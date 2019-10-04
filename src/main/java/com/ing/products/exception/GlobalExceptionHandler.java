package com.ing.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


@ExceptionHandler(ProductDoesntExistException.class)
public ResponseEntity<ResponseError> productNotFoundException(ProductDoesntExistException ex) {
ResponseError error = new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}

@ExceptionHandler(CategoryDoesntExistException.class)
public ResponseEntity<ResponseError> categoryNotFoundException(CategoryDoesntExistException ex) {
ResponseError error = new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}



@ExceptionHandler(FailUploadException.class)
public ResponseEntity<ResponseError> failUploadException(FailUploadException ex) {
ResponseError error = new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}
}
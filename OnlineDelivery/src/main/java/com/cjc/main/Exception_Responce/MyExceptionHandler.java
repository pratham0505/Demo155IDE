package com.cjc.main.Exception_Responce;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cjc.main.Exception.ProductNotFountException;
import com.cjc.main.Model.BaseResponce;
import com.cjc.main.Model.Product;


@RestControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value = ProductNotFountException.class)
	public ResponseEntity<BaseResponce<Product>> handleProductNotFound(){
		
		return new ResponseEntity<BaseResponce<Product>>(new BaseResponce<Product>(404,"Product Not Found", new Date(),null),HttpStatus.NOT_FOUND);
	}

}

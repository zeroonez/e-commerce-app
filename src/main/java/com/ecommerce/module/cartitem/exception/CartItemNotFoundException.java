package com.ecommerce.module.cartitem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartItemNotFoundException extends Exception {

	public CartItemNotFoundException() {
	}

}

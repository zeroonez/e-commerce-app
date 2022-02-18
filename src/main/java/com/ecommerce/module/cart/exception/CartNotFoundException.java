package com.ecommerce.module.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartNotFoundException extends Exception {

	public CartNotFoundException() {
	}

}

package com.ecommerce.module.cart.exception;

import com.ecommerce.common.exception.ApiException;

public class CartNotFoundException extends ApiException {

	@Override
	protected String getErrorMessage() {
		return "Cart not found";
	}
}

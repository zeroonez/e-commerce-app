package com.ecommerce.module.cartitem.exception;

import com.ecommerce.common.exception.ApiException;

public class CartItemNotFoundException extends ApiException {

	@Override
	protected String getErrorMessage() {
		return "Item in cart not found";
	}
}

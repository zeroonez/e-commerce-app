package com.ecommerce.module.item.exception;

import com.ecommerce.common.exception.ApiException;

public class ItemNotFoundException extends ApiException {

	@Override
	protected String getErrorMessage() {
		return "Item not found in stock";
	}
}

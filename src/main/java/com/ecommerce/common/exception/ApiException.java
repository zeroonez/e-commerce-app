package com.ecommerce.common.exception;

public abstract class ApiException extends Exception {

	protected abstract String getErrorMessage();

	@Override
	public String getMessage() {
		return getErrorMessage();
	}

}

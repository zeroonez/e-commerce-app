package com.ecommerce.module.cart.controller.dto;

import com.ecommerce.module.cartitem.controller.dto.CartItemResponse;

import java.util.Set;
import java.util.UUID;

public class CartResponse {

	private UUID id;

	private Set<CartItemResponse> cartItems;

	public CartResponse(UUID id, Set<CartItemResponse> cartItems) {
		this.id = id;
		this.cartItems = cartItems;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Set<CartItemResponse> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItemResponse> cartItems) {
		this.cartItems = cartItems;
	}

}

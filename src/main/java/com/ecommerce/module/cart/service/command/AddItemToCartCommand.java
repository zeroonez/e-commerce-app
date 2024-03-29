package com.ecommerce.module.cart.service.command;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AddItemToCartCommand {

	@NotNull
	@JsonIgnore
	private UUID cartId;

	@NotNull
	private UUID itemId;

	@NotNull
	private int quantity;

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public UUID getItemId() {
		return itemId;
	}

	public void setItemId(UUID itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

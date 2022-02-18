package com.ecommerce.module.cart.service.command;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Validated
public class AddItemToCartCommand {

	@NotNull
	private UUID cartId;

	@NotNull
	private UUID itemId;

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

}

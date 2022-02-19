package com.ecommerce.module.cart.service.command;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class RemoveOrReduceItemFromCartCommand {

	@NotNull
	@JsonIgnore
	private UUID cartId;

	@NotNull
	private UUID itemId;

	public RemoveOrReduceItemFromCartCommand(UUID cartId, UUID itemId) {
		this.cartId = cartId;
		this.itemId = itemId;
	}

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

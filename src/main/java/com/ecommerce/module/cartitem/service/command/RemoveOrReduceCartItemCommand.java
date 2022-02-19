package com.ecommerce.module.cartitem.service.command;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class RemoveOrReduceCartItemCommand {

	@NotNull
	private UUID cartId;

	@NotNull
	private UUID itemId;

	public RemoveOrReduceCartItemCommand(UUID cartId, UUID itemId) {
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

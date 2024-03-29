package com.ecommerce.module.cartitem.service.command;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CreateCartItemCommand {

	@NotNull
	private UUID cartId;

	@NotNull
	private UUID itemId;

	@NotNull
	private int quantity;

	public CreateCartItemCommand(UUID cartId, UUID itemId, int quantity) {
		this.cartId = cartId;
		this.itemId = itemId;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

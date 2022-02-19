package com.ecommerce.module.cartitem.controller.dto;

import com.ecommerce.module.item.controller.dto.ItemResponse;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CartItemResponse {

	@NotNull
	private UUID id;

	@NotNull
	private ItemResponse item;

	@NotNull
	private int quantity;

	public CartItemResponse(UUID id, ItemResponse item, int quantity) {
		this.id = id;
		this.item = item;
		this.quantity = quantity;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ItemResponse getItem() {
		return item;
	}

	public void setItem(ItemResponse item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

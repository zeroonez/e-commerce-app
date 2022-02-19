package com.ecommerce.module.cartitem.controller.dto;

import com.ecommerce.module.item.controller.dto.ItemResponse;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CartItemResponse {

	@NotNull
	private ItemResponse item;

	@NotNull
	private int quantity;

	public CartItemResponse(ItemResponse item, int quantity) {
		this.item = item;
		this.quantity = quantity;
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

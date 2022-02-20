package com.ecommerce.module.item.service.command;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class IncreaseItemStockCommand {

	@NotNull
	@JsonIgnore
	private UUID itemId;

	@NotNull
	private int stockToAdd;

	public UUID getItemId() {
		return itemId;
	}

	public void setItemId(UUID itemId) {
		this.itemId = itemId;
	}

	public int getStockToAdd() {
		return stockToAdd;
	}

	public void setStockToAdd(int stockToAdd) {
		this.stockToAdd = stockToAdd;
	}
}

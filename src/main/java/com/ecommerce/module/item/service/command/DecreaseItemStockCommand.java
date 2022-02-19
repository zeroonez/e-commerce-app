package com.ecommerce.module.item.service.command;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class DecreaseItemStockCommand {

	@NotNull
	private UUID itemId;

	@NotNull
	private int stockToRemove;

	public UUID getItemId() {
		return itemId;
	}

	public void setItemId(UUID itemId) {
		this.itemId = itemId;
	}

	public int getStockToRemove() {
		return stockToRemove;
	}

	public void setStockToRemove(int stockToRemove) {
		this.stockToRemove = stockToRemove;
	}
}

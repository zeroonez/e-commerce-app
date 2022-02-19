package com.ecommerce.module.item.service.command;

import javax.validation.constraints.NotNull;

public class CreateItemCommand {

	@NotNull
	private String name;

	@NotNull
	private String description;

	@NotNull
	private float price;

	@NotNull
	private int stock;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}

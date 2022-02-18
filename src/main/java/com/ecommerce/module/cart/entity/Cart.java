package com.ecommerce.module.cart.entity;

import com.ecommerce.common.converter.UuidSetConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
public class Cart {

	@Id
	@GeneratedValue(generator = "uuid2")
	@NotNull
	private UUID id;

	@Convert(converter = UuidSetConverter.class)
	private Set<UUID> itemIds;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Set<UUID> getItemIds() {
		return itemIds;
	}

	public void setItemIds(Set<UUID> itemIds) {
		this.itemIds = itemIds;
	}
}

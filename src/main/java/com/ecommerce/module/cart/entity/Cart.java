package com.ecommerce.module.cart.entity;

import com.ecommerce.common.converter.UuidSetConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Cart {

	@Id
	@GeneratedValue(generator = "uuid2")
	@NotNull
	private UUID id;

	@Convert(converter = UuidSetConverter.class)
	private Set<UUID> cartItemIds = new HashSet<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Set<UUID> getCartItemIds() {
		return cartItemIds;
	}

	public void setCartItemIds(Set<UUID> cartItemIds) {
		this.cartItemIds = cartItemIds;
	}
}

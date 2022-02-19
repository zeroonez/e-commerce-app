package com.ecommerce.module.cartitem.service;

import com.ecommerce.module.cartitem.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class CartItemFinderService {

	private final CartItemRepository cartItemRepository;

	public CartItemFinderService(CartItemRepository cartItemRepository) {
		this.cartItemRepository = cartItemRepository;
	}

	public Set<CartItem> getAllByIds(Set<UUID> ids) {
		return new HashSet<>(cartItemRepository.findAllById(ids));
	}

	public CartItem getByCartIdAndItemId(UUID cartId, UUID itemId) {
		return cartItemRepository.findByCartIdAndItemId(cartId, itemId);
	}

}

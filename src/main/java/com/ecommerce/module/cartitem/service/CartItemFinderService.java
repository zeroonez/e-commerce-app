package com.ecommerce.module.cartitem.service;

import com.ecommerce.module.cartitem.entity.CartItem;
import com.ecommerce.module.cartitem.exception.CartItemNotFoundException;
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

	public CartItem getByCartIdAndItemId(UUID cartId, UUID itemId) throws CartItemNotFoundException {
		return cartItemRepository.findByCartIdAndItemId(cartId, itemId)
				.orElseThrow(CartItemNotFoundException::new);
	}

	public Set<CartItem> getALLByCartId(UUID cartId) {
		return cartItemRepository.findAllByCartId(cartId);
	}

}

package com.ecommerce.module.cart.service;

import com.ecommerce.module.cart.entity.Cart;
import com.ecommerce.module.cart.exception.CartNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartFinderService {

	private final CartRepository cartRepository;

	public CartFinderService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	public Cart getById(UUID id) throws CartNotFoundException {
		return cartRepository.findById(id).orElseThrow(CartNotFoundException::new);
	}
}

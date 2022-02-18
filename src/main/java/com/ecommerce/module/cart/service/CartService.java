package com.ecommerce.module.cart.service;

import com.ecommerce.module.cart.entity.Cart;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import com.ecommerce.module.item.service.ItemFinderService;
import com.ecommerce.module.cart.exception.CartNotFoundException;
import com.ecommerce.module.cart.service.command.AddItemToCartCommand;
import com.ecommerce.module.item.entity.Item;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class CartService {

	private final CartRepository cartRepository;
	private final CartFinderService cartFinderService;
	private final ItemFinderService itemFinderService;

	public CartService(CartRepository cartRepository,
	                   CartFinderService cartFinderService,
	                   ItemFinderService itemFinderService) {
		this.cartRepository = cartRepository;
		this.cartFinderService = cartFinderService;
		this.itemFinderService = itemFinderService;
	}

	public Cart createCart() {
		return cartRepository.save(new Cart());
	}

	public Cart addItemToCart(@Valid AddItemToCartCommand command) throws CartNotFoundException, ItemNotFoundException {
		Cart cart = cartFinderService.getById(command.getCartId());
		Item item = itemFinderService.getById(command.getItemId());
		cart.getItemIds().add(item.getId());
		return cartRepository.save(cart);
	}
}

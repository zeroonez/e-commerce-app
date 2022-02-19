package com.ecommerce.module.cartitem.service;

import com.ecommerce.module.cartitem.entity.CartItem;
import com.ecommerce.module.cartitem.service.command.AddItemToCartItemCommand;
import com.ecommerce.module.item.entity.Item;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import com.ecommerce.module.item.service.ItemFinderService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class CartItemService {

	private final CartItemRepository cartItemRepository;
	private final CartItemFinderService cartItemFinderService;
	private final ItemFinderService itemFinderService;

	public CartItemService(CartItemRepository cartItemRepository,
	                       CartItemFinderService cartItemFinderService,
	                       ItemFinderService itemFinderService) {
		this.cartItemRepository = cartItemRepository;
		this.cartItemFinderService = cartItemFinderService;
		this.itemFinderService = itemFinderService;
	}

	public CartItem addItemToCartItem(@Valid AddItemToCartItemCommand command) throws ItemNotFoundException {
		CartItem cartItem = cartItemFinderService.getByCartIdAndItemId(command.getCartId(), command.getItemId());
		Item item = itemFinderService.getById(command.getItemId());
		if (cartItem != null) {
			cartItem.setQuantity(cartItem.getQuantity() + command.getQuantity());
		} else {
			cartItem = new CartItem();
			cartItem.setItemId(item.getId());
			cartItem.setCartId(command.getCartId());
			cartItem.setQuantity(command.getQuantity());
		}
		return cartItemRepository.save(cartItem);
	}
}

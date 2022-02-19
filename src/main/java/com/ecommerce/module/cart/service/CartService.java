package com.ecommerce.module.cart.service;

import com.ecommerce.module.cart.entity.Cart;
import com.ecommerce.module.cartitem.entity.CartItem;
import com.ecommerce.module.cartitem.service.CartItemFinderService;
import com.ecommerce.module.cartitem.service.CartItemService;
import com.ecommerce.module.cartitem.service.command.AddItemToCartItemCommand;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import com.ecommerce.module.item.service.ItemFinderService;
import com.ecommerce.module.cart.exception.CartNotFoundException;
import com.ecommerce.module.cart.service.command.AddItemToCartCommand;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class CartService {

	private final CartRepository cartRepository;
	private final CartFinderService cartFinderService;
	private final ItemFinderService itemFinderService;
	private final CartItemFinderService cartItemFinderService;
	private final CartItemService cartItemService;

	public CartService(CartRepository cartRepository,
	                   CartFinderService cartFinderService,
	                   ItemFinderService itemFinderService,
	                   CartItemFinderService cartItemFinderService, CartItemService cartItemService) {
		this.cartRepository = cartRepository;
		this.cartFinderService = cartFinderService;
		this.itemFinderService = itemFinderService;
		this.cartItemFinderService = cartItemFinderService;
		this.cartItemService = cartItemService;
	}

	public Cart createCart() {
		return cartRepository.save(new Cart());
	}

	public Cart addItemToCart(@Valid AddItemToCartCommand command) throws CartNotFoundException, ItemNotFoundException {
		Cart cart = cartFinderService.getById(command.getCartId());

		AddItemToCartItemCommand addItemToCartItemCommand = new AddItemToCartItemCommand();
		addItemToCartItemCommand.setCartId(cart.getId());
		addItemToCartItemCommand.setItemId(command.getItemId());
		addItemToCartItemCommand.setQuantity(command.getQuantity());
		CartItem cartItem = cartItemService.addItemToCartItem(addItemToCartItemCommand);

		cart.getCartItemIds().add(cartItem.getId());
		return cartRepository.save(cart);
	}
}

package com.ecommerce.module.cart.service;

import com.ecommerce.module.cart.entity.Cart;
import com.ecommerce.module.cart.service.command.RemoveOrReduceItemFromCartCommand;
import com.ecommerce.module.cartitem.entity.CartItem;
import com.ecommerce.module.cartitem.exception.CartItemNotFoundException;
import com.ecommerce.module.cartitem.service.CartItemService;
import com.ecommerce.module.cartitem.service.command.CreateCartItemCommand;
import com.ecommerce.module.cartitem.service.command.RemoveOrReduceCartItemCommand;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import com.ecommerce.module.cart.exception.CartNotFoundException;
import com.ecommerce.module.cart.service.command.AddItemToCartCommand;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@Validated
public class CartService {

	private final CartRepository cartRepository;
	private final CartFinderService cartFinderService;
	private final CartItemService cartItemService;

	public CartService(CartRepository cartRepository,
	                   CartFinderService cartFinderService,
	                   CartItemService cartItemService) {
		this.cartRepository = cartRepository;
		this.cartFinderService = cartFinderService;
		this.cartItemService = cartItemService;
	}

	public Cart createCart() {
		return cartRepository.save(new Cart());
	}

	public Cart addItemToCart(@Valid AddItemToCartCommand command) throws CartNotFoundException, ItemNotFoundException {
		Cart cart = cartFinderService.getById(command.getCartId());

		CartItem cartItem = cartItemService.createCartItem(new CreateCartItemCommand(
				cart.getId(),
				command.getItemId(),
				command.getQuantity()
		));
		Set<UUID> cartItems = new HashSet<>(cart.getCartItemIds());
		cartItems.add(cartItem.getId());
		cart.setCartItemIds(cartItems);
		return cartRepository.save(cart);
	}

	public Cart removeItemFromCart(@Valid RemoveOrReduceItemFromCartCommand command) throws CartNotFoundException,
			CartItemNotFoundException {
		Cart cart = cartFinderService.getById(command.getCartId());
		UUID removedCartItemId = cartItemService.removeCartItem(new RemoveOrReduceCartItemCommand(
				cart.getId(),
				command.getItemId()
		));
		cart.getCartItemIds().remove(removedCartItemId);
		return cartRepository.save(cart);
	}

	public Cart reduceItemFromCart(@Valid RemoveOrReduceItemFromCartCommand command) throws CartNotFoundException,
			CartItemNotFoundException {
		Cart cart = cartFinderService.getById(command.getCartId());
		cartItemService.reduceCartItemQuantity(new RemoveOrReduceCartItemCommand(
				cart.getId(),
				command.getItemId()
		));
		return cart;
	}
}

package com.ecommerce.module.cartitem.service;

import com.ecommerce.module.cartitem.entity.CartItem;
import com.ecommerce.module.cartitem.exception.CartItemNotFoundException;
import com.ecommerce.module.cartitem.service.command.CreateCartItemCommand;
import com.ecommerce.module.cartitem.service.command.RemoveOrReduceCartItemCommand;
import com.ecommerce.module.item.entity.Item;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import com.ecommerce.module.item.service.ItemFinderService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.UUID;

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

	public CartItem createCartItem(@Valid CreateCartItemCommand command) throws ItemNotFoundException {
		CartItem cartItem = cartItemRepository.findByCartIdAndItemId(command.getCartId(), command.getItemId())
				.orElse(null);
		Item item = itemFinderService.getById(command.getItemId());
		if (cartItem != null) {
			cartItem.setQuantity(command.getQuantity());
		} else {
			cartItem = new CartItem();
			cartItem.setItemId(item.getId());
			cartItem.setCartId(command.getCartId());
			cartItem.setQuantity(command.getQuantity());
		}
		return cartItemRepository.save(cartItem);
	}

	public UUID removeCartItem(@Valid RemoveOrReduceCartItemCommand command) throws CartItemNotFoundException {
		CartItem cartItem = cartItemFinderService.getByCartIdAndItemId(command.getCartId(), command.getItemId());
		UUID cartIdToBeRemoved = cartItem.getId();
		cartItemRepository.delete(cartItem);
		return cartIdToBeRemoved;
	}

	public void reduceCartItemQuantity(@Valid RemoveOrReduceCartItemCommand command) throws CartItemNotFoundException {
		CartItem cartItem = cartItemFinderService.getByCartIdAndItemId(command.getCartId(), command.getItemId());
		int newQuantity = cartItem.getQuantity() - 1 < 1 ? 0 : cartItem.getQuantity() - 1;
		cartItem.setQuantity(newQuantity);
		cartItemRepository.save(cartItem);
	}
}
